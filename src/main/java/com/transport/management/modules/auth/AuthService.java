package com.transport.management.modules.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.transport.management.enums.RoleEnum;
import com.transport.management.modules.auth.requests.LoginRequest;
import com.transport.management.modules.auth.requests.RegisterRequest;
import com.transport.management.modules.auth.response.AuthResponse;
import com.transport.management.modules.usuario.UsuarioEntity;
import com.transport.management.modules.usuario.UsuarioRepository;
import com.transport.management.utils.jwt.JwtService;

@Service
public class AuthService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    JwtService jwtService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        try {
            // Autenticar al usuario
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Usuario o contraseña incorrectos");
        }

        // Buscar al usuario en la base de datos
        UsuarioEntity user = usuarioRepository.findByEmail(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));

        // Generar el token JWT
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .name(user.getNombre())
                .build();
    }

    public Map<String, String> register(RegisterRequest request) {
        if (usuarioRepository.findByEmail(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("El correo electrónico ya está registrado");
        }

        if (request.getUsername() == null || request.getUsername().isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico es obligatorio");
        }

        if (request.getName() == null || request.getName().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            throw new IllegalArgumentException("La contraseña es obligatoria");
        }

        if (request.getUsername().length() > 50) {
            throw new IllegalArgumentException("El correo electrónico no puede exceder los 50 caracteres");
        }

        if (request.getName().length() > 50) {
            throw new IllegalArgumentException("El nombre no puede exceder los 50 caracteres");
        }

        UsuarioEntity user = UsuarioEntity.builder()
                .nombre(request.getName())
                .email(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(RoleEnum.USER)
                .build();

        usuarioRepository.save(user);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario creado correctamente");
        return response;
    }
}
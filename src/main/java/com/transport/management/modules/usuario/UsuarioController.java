package com.transport.management.modules.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
  @Autowired
  UsuarioService usuarioService;

  @GetMapping
  public List<UsuarioEntity> findAll() {
    return usuarioService.findAll();
  }

  @GetMapping("/{id}")
  public UsuarioEntity findById(@PathVariable Long id) {
    return usuarioService.findById(id);
  }

  @PostMapping
  public UsuarioEntity save(@RequestBody UsuarioEntity usuario) {
    return usuarioService.save(usuario);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    usuarioService.deleteById(id);
  }
}

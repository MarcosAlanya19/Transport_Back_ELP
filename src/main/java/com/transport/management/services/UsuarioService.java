package com.transport.management.services;

import java.util.List;

import com.transport.management.entities.UsuarioEntity;

public interface UsuarioService {
    List<UsuarioEntity> findAll();
    UsuarioEntity findById(Long id);
    UsuarioEntity save(UsuarioEntity usuario);
    void deleteById(Long id);
}
package com.transport.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transport.management.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
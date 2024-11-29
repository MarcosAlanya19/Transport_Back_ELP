package com.transport.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transport.management.entities.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
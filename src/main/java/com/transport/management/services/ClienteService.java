package com.transport.management.services;

import java.util.List;

import com.transport.management.entities.ClienteEntity;

public interface ClienteService {
    List<ClienteEntity> findAll();
    ClienteEntity findById(Long id);
    ClienteEntity save(ClienteEntity cliente);
    void deleteById(Long id);
}
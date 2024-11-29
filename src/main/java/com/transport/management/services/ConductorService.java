package com.transport.management.services;


import com.transport.management.entities.ConductorEntity;

import java.util.List;

public interface ConductorService {
    List<ConductorEntity> findAll();
    ConductorEntity findById(Long id);
    ConductorEntity save(ConductorEntity conductorEntity);
    void deleteById(Long id);
    List<ConductorEntity> findByDisponible(boolean disponible);
}

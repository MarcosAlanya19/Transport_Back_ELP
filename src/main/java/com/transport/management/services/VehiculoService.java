package com.transport.management.services;

import com.transport.management.entities.VehiculoEntity;

import java.util.List;

public interface VehiculoService {
    List<VehiculoEntity> findAll();
    VehiculoEntity findById(Long id);
    VehiculoEntity save(VehiculoEntity vehiculo);
    void deleteById(Long id);
    List<VehiculoEntity> findByEnServicio(boolean enServicio);
}
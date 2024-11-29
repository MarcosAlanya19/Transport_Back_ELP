package com.transport.management.services;

import com.transport.management.entities.ViajeEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface ViajeService {
    List<ViajeEntity> findAll();
    ViajeEntity findById(Long id);
    ViajeEntity save(ViajeEntity viaje);
    void deleteById(Long id);
    List<ViajeEntity> findByFechaHoraSalidaAfter(LocalDateTime fechaHora);
}

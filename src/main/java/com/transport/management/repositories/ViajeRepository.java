package com.transport.management.repositories;

import com.transport.management.entities.ViajeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ViajeRepository extends JpaRepository<ViajeEntity, Long> {
    List<ViajeEntity> findByFechaHoraSalidaAfter(LocalDateTime fechaHora);
    List<ViajeEntity> findByConductorId(Long conductorId);
    List<ViajeEntity> findByVehiculoId(Long vehiculoId);
}

package com.transport.management.repositories;

import com.transport.management.entities.VehiculoEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {
    List<VehiculoEntity> findByEnServicio(boolean enServicio);
}

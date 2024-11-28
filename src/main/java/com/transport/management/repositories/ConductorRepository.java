package com.transport.management.repositories;

import com.transport.management.entities.Conductor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    List<Conductor> findByDisponible(boolean disponible);
}

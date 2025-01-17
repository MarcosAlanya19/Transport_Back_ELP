package com.transport.management.modules.conductor;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.transport.management.utils.abtractBase.BaseRepository;

@Repository
public interface ConductorRepository extends BaseRepository<ConductorEntity> {
  boolean existsByLicencia(String licencia);

  boolean existsByDni(String dni);

  List<ConductorEntity> findByDisponibleTrue();

}
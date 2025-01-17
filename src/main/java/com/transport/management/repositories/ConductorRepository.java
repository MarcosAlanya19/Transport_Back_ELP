package com.transport.management.repositories;

import java.util.List;

import com.transport.management.modules.conductor.ConductorEntity;
import com.transport.management.utils.abtractBase.BaseRepository;

public interface ConductorRepository extends BaseRepository<ConductorEntity> {
  List<ConductorEntity> findByDisponible(boolean disponible);
}

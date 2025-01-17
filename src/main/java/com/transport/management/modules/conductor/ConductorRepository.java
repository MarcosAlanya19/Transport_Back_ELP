package com.transport.management.modules.conductor;

import java.util.List;

import com.transport.management.utils.abtractBase.BaseRepository;

public interface ConductorRepository extends BaseRepository<ConductorEntity> {
  List<ConductorEntity> findByDisponible(boolean disponible);
}

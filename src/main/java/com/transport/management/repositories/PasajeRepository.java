package com.transport.management.repositories;

import java.util.List;

import com.transport.management.entities.PasajeEntity;
import com.transport.management.utils.abtractBase.BaseRepository;

public interface PasajeRepository extends BaseRepository<PasajeEntity> {
  List<PasajeEntity> findByViajeId(Long viajeId);
}

package com.transport.management.repositories;

import java.util.List;

import com.transport.management.entities.VehiculoEntity;
import com.transport.management.utils.abtractBase.BaseRepository;

public interface VehiculoRepository extends BaseRepository<VehiculoEntity> {
    List<VehiculoEntity> findByEnServicio(boolean enServicio);
}

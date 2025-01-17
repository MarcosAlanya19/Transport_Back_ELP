package com.transport.management.modules.vehiculo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.transport.management.utils.abtractBase.BaseRepository;

@Repository
public interface VehiculoRepository extends BaseRepository<VehiculoEntity> {
    boolean existsByPlaca(String placa);

    List<VehiculoEntity> findByConductorIsNull();

}
package com.transport.management.modules.viaje;

import java.time.LocalDateTime;
import java.util.List;

import com.transport.management.utils.abtractBase.BaseRepository;

public interface ViajeRepository extends BaseRepository<ViajeEntity> {
    List<ViajeEntity> findByFechaHoraSalidaAfter(LocalDateTime fechaHora);

    List<ViajeEntity> findByConductorId(Long conductorId);

    List<ViajeEntity> findByVehiculoId(Long vehiculoId);
}

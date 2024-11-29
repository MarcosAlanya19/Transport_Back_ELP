package com.transport.management.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.management.entities.ViajeEntity;
import com.transport.management.repositories.ViajeRepository;
import com.transport.management.utils.abtractBase.BaseService;

@Service
public class ViajeService extends BaseService<ViajeEntity> {
  @Autowired
  ViajeRepository viajeRepository;

  public List<ViajeEntity> findByFechaHoraSalidaAfter(LocalDateTime fechaHora) {
    return viajeRepository.findByFechaHoraSalidaAfter(fechaHora);
  }
}

package com.transport.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.management.entities.PasajeEntity;
import com.transport.management.repositories.PasajeRepository;
import com.transport.management.utils.abtractBase.BaseService;

@Service
public class PasajeService extends BaseService<PasajeEntity> {
  @Autowired
  PasajeRepository pasajeRepository;

  public List<PasajeEntity> findByViajeId(Long viajeId) {
    return pasajeRepository.findByViajeId(viajeId);
  }
}

package com.transport.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.management.entities.ConductorEntity;
import com.transport.management.repositories.ConductorRepository;
import com.transport.management.utils.abtractBase.BaseService;

@Service
public class ConductorService extends BaseService<ConductorEntity> {
  @Autowired
  ConductorRepository conductorRepository;

  public List<ConductorEntity> findByDisponible(boolean disponible) {
    return conductorRepository.findByDisponible(disponible);
  }
}

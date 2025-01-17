package com.transport.management.modules.conductor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.management.utils.abtractBase.BaseService;

@Service
public class ConductorService extends BaseService<ConductorEntity> {
  @Autowired
  ConductorRepository conductorRepository;

  public List<ConductorEntity> findByDisponible(boolean disponible) {
    return conductorRepository.findByDisponible(disponible);
  }
}

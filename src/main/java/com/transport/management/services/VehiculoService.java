package com.transport.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.management.entities.VehiculoEntity;
import com.transport.management.repositories.VehiculoRepository;
import com.transport.management.utils.abtractBase.BaseService;

@Service
public class VehiculoService extends BaseService<VehiculoEntity> {
  @Autowired
  VehiculoRepository vehiculoRepository;

  public List<VehiculoEntity> findByEnServicio(boolean enServicio) {
    return vehiculoRepository.findByEnServicio(enServicio);
  }
}

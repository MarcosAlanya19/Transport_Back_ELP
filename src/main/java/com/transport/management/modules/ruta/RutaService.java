package com.transport.management.modules.ruta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.management.modules.ruta.request.RutaRequest;
import com.transport.management.utils.abtractBase.BaseService;

import jakarta.transaction.Transactional;

@Service
public class RutaService extends BaseService<RutaEntity> {
  @Autowired
  RutaRepository rutaRepository;

  @Transactional
  public RutaEntity update(Long id, RutaRequest rutaRequest) {
    RutaEntity existingRuta = rutaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Ruta no encontrada"));
    existingRuta.setOrigen(rutaRequest.getOrigen());
    existingRuta.setDestino(rutaRequest.getDestino());
    existingRuta.setDistancia(rutaRequest.getDistancia());
    existingRuta.setPrecioBase(rutaRequest.getPrecioBase());
    return rutaRepository.save(existingRuta);
  }

}
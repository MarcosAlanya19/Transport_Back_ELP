package com.transport.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transport.management.entities.PasajeEntity;
import com.transport.management.services.PasajeService;

@RestController
@RequestMapping("/pasajes")
public class PasajeController {
  @Autowired
  PasajeService pasajeService;

  @GetMapping
  public List<PasajeEntity> findAll() {
    return pasajeService.findAll();
  }

  @GetMapping("/{id}")
  public PasajeEntity findById(@PathVariable Long id) {
    return pasajeService.findById(id);
  }

  @PostMapping
  public PasajeEntity save(@RequestBody PasajeEntity pasaje) {
    return pasajeService.save(pasaje);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    pasajeService.deleteById(id);
  }

  @GetMapping("/viaje/{viajeId}")
  public List<PasajeEntity> findByViajeId(@PathVariable Long viajeId) {
    return pasajeService.findByViajeId(viajeId);
  }
}

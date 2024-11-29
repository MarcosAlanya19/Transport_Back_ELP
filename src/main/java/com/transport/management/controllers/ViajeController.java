package com.transport.management.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transport.management.entities.ViajeEntity;
import com.transport.management.services.ViajeService;

@RestController
@RequestMapping("/viajes")
public class ViajeController {
  @Autowired
  ViajeService viajeService;

  @GetMapping
  public List<ViajeEntity> findAll() {
    return viajeService.findAll();
  }

  @GetMapping("/{id}")
  public ViajeEntity findById(@PathVariable Long id) {
    return viajeService.findById(id);
  }

  @PostMapping
  public ViajeEntity save(@RequestBody ViajeEntity viaje) {
    return viajeService.save(viaje);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    viajeService.deleteById(id);
  }

  @GetMapping("/proximos")
  public List<ViajeEntity> findByFechaHoraSalidaAfter(@RequestParam LocalDateTime fechaHora) {
    return viajeService.findByFechaHoraSalidaAfter(fechaHora);
  }
}

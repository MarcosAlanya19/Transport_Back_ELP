package com.transport.management.controllers;

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

import com.transport.management.entities.VehiculoEntity;
import com.transport.management.services.VehiculoService;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
  @Autowired
  VehiculoService vehiculoService;

  @GetMapping
  public List<VehiculoEntity> findAll() {
    return vehiculoService.findAll();
  }

  @GetMapping("/{id}")
  public VehiculoEntity findById(@PathVariable Long id) {
    return vehiculoService.findById(id);
  }

  @PostMapping
  public VehiculoEntity save(@RequestBody VehiculoEntity vehiculo) {
    return vehiculoService.save(vehiculo);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    vehiculoService.deleteById(id);
  }

  @GetMapping("/disponibles")
  public List<VehiculoEntity> findByEnServicio(@RequestParam boolean enServicio) {
    return vehiculoService.findByEnServicio(enServicio);
  }
}

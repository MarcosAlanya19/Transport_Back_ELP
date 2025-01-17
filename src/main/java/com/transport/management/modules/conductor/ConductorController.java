package com.transport.management.modules.conductor;

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

import com.transport.management.entities.ConductorEntity;
import com.transport.management.services.ConductorService;

@RestController
@RequestMapping("/conductores")
public class ConductorController {
  @Autowired
  ConductorService conductorService;

  @GetMapping
  public List<ConductorEntity> findAll() {
    return conductorService.findAll();
  }

  @GetMapping("/{id}")
  public ConductorEntity findById(@PathVariable Long id) {
    return conductorService.findById(id);
  }

  @PostMapping
  public ConductorEntity save(@RequestBody ConductorEntity conductor) {
    return conductorService.save(conductor);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    conductorService.deleteById(id);
  }

  @GetMapping("/disponibles")
  public List<ConductorEntity> findByDisponible(@RequestParam boolean disponible) {
    return conductorService.findByDisponible(disponible);
  }
}

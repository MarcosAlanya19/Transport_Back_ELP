package com.transport.management.modules.ruta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rutas")
public class RutaController {
  @Autowired
  RutaService rutaService;

  @GetMapping
  public List<RutaEntity> findAll() {
    return rutaService.findAll();
  }

  @GetMapping("/{id}")
  public RutaEntity findById(@PathVariable Long id) {
    return rutaService.findById(id);
  }

  @PostMapping
  public RutaEntity save(@RequestBody RutaEntity ruta) {
    return rutaService.save(ruta);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    rutaService.deleteById(id);
  }
}

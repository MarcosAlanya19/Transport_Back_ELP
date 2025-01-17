package com.transport.management.modules.viaje;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transport.management.enums.StatusViajeEnum;
import com.transport.management.modules.viaje.request.ViajeRequest;

@RestController
@RequestMapping(value = "/viajes")
@CrossOrigin(origins = "*")
public class ViajeController {
  @Autowired
  ViajeService viajeService;

  @GetMapping
  public ResponseEntity<List<ViajeEntity>> findAll() {
    List<ViajeEntity> viajes = viajeService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(viajes);
  }

  @PostMapping
  public ResponseEntity<ViajeEntity> crearViaje(@RequestBody ViajeRequest request) {
    ViajeEntity viaje = viajeService.save(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(viaje);
  }

  @PostMapping(value = "/{id}/delete")
  public void deleteById(@PathVariable Long id) {
    viajeService.deleteById(id);
  }

  @PostMapping("/{viajeId}/estado")
  public ResponseEntity<ViajeEntity> cambiarEstadoViaje(
      @PathVariable Long viajeId,
      @RequestParam StatusViajeEnum nuevoEstado) {
    try {
      ViajeEntity viajeActualizado = viajeService.cambiarEstado(viajeId, nuevoEstado);
      return ResponseEntity.ok(viajeActualizado);
    } catch (RuntimeException e) {
      return ResponseEntity.badRequest().body(null);
    }
  }
}

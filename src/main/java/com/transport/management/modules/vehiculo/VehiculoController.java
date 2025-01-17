package com.transport.management.modules.vehiculo;

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
import org.springframework.web.bind.annotation.RestController;

import com.transport.management.modules.vehiculo.request.VehiculoRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/vehiculos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VehiculoController {
  @Autowired
  VehiculoService vehiculoService;

  @GetMapping
  public ResponseEntity<List<VehiculoEntity>> findAll() {
    List<VehiculoEntity> vehiculos = vehiculoService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(vehiculos);
  }

  @PostMapping
  public ResponseEntity<VehiculoEntity> save(@RequestBody VehiculoRequest vehiculoRequest) {
    VehiculoEntity savedVehiculo = vehiculoService.save(vehiculoRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedVehiculo);
  }

  @PostMapping("/{id}/update")
  public ResponseEntity<VehiculoEntity> updateVehiculo(@PathVariable Long id,
      @RequestBody VehiculoRequest vehiculoRequest) {
    VehiculoEntity updatedVehiculo = vehiculoService.update(id, vehiculoRequest);
    return ResponseEntity.ok(updatedVehiculo);
  }

  @GetMapping("/sin-conductor")
  public ResponseEntity<List<VehiculoEntity>> findVehiculosSinConductor() {
    List<VehiculoEntity> vehiculosSinConductor = vehiculoService.findVehiculosSinConductor();
    return ResponseEntity.status(HttpStatus.OK).body(vehiculosSinConductor);
  }

  @PostMapping("/{id}/delete")
  public ResponseEntity<String> deleteVehiculo(@PathVariable Long id) {
    vehiculoService.deleteVehiculo(id);
    return ResponseEntity.ok("Vehículo eliminado exitosamente.");
  }
}

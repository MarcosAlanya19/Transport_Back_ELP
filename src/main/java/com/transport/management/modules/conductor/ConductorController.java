package com.transport.management.modules.conductor;

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

import com.transport.management.modules.conductor.request.ConductorRequest;
import com.transport.management.modules.conductor.response.ConductorResponse;

@RestController
@RequestMapping("/conductores")
@CrossOrigin(origins = "*")
public class ConductorController {
  @Autowired
  ConductorService conductorService;

  @GetMapping
  public ResponseEntity<List<ConductorResponse>> findAll() {
    List<ConductorResponse> conductores = conductorService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(conductores);
  }

  @GetMapping("/disponibles")
  public ResponseEntity<List<ConductorResponse>> getAllAvailableConductores() {
    return ResponseEntity.status(HttpStatus.OK).body(conductorService.findAllAvailable());
  }

  @PostMapping
  public ResponseEntity<ConductorEntity> save(@RequestBody ConductorRequest conductorRequest) {
    ConductorEntity conductor = new ConductorEntity();
    conductor.setDni(conductorRequest.getDni());
    conductor.setApellidos(conductorRequest.getApellidos());
    conductor.setNombres(conductorRequest.getNombres());
    conductor.setLicencia(conductorRequest.getLicencia());
    conductor.setDisponible(conductorRequest.getDisponible());

    ConductorEntity savedConductor = conductorService.save(conductor, conductorRequest.getVehiculoId());

    return ResponseEntity.status(HttpStatus.CREATED).body(savedConductor);
  }

  @PostMapping(value = "/{id}/delete")
  public ResponseEntity<Void> deleteConductor(@PathVariable Long id) {
    conductorService.deleteDriverById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @PostMapping(value = "/{id}/update")
  public ResponseEntity<ConductorEntity> updateConductor(
      @PathVariable Long id,
      @RequestBody ConductorRequest conductorRequest) {
    ConductorEntity updatedConductor = conductorService.updateConductor(id, conductorRequest);
    return ResponseEntity.status(HttpStatus.OK).body(updatedConductor);
  }
}

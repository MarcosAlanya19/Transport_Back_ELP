package com.transport.management.modules.ruta;

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

import com.transport.management.modules.ruta.request.RutaRequest;

@RestController
@RequestMapping("/rutas")
@CrossOrigin(origins = "*")
public class RutaController {
  @Autowired
  RutaService rutaService;

  @GetMapping
  public ResponseEntity<List<RutaEntity>> findAll() {
    List<RutaEntity> rutaEntities = rutaService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(rutaEntities);
  }

  @PostMapping
  public ResponseEntity<RutaEntity> save(@RequestBody RutaRequest rutaRequest) {
    RutaEntity ruta = new RutaEntity();
    ruta.setOrigen(rutaRequest.getOrigen());
    ruta.setDestino(rutaRequest.getDestino());
    ruta.setDistancia(rutaRequest.getDistancia());
    ruta.setPrecioBase(rutaRequest.getPrecioBase());

    RutaEntity savedRuta = rutaService.save(ruta);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedRuta);
  }

  @PostMapping(value = "/{id}/delete")
  public ResponseEntity<Void> deleteRuta(@PathVariable Long id) {
    rutaService.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @PostMapping(value = "/{id}/update")
  public ResponseEntity<RutaEntity> updateRuta(
      @PathVariable Long id,
      @RequestBody RutaRequest rutaRequest) {
    RutaEntity updatedRuta = rutaService.update(id, rutaRequest);
    return ResponseEntity.status(HttpStatus.OK).body(updatedRuta);
  }
}
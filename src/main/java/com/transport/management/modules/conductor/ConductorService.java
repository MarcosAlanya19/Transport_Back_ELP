package com.transport.management.modules.conductor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.transport.management.entities.VehiculoEntity;
import com.transport.management.modules.conductor.request.ConductorRequest;
import com.transport.management.modules.conductor.response.ConductorResponse;
import com.transport.management.modules.conductor.response.VehiculoResponse;
import com.transport.management.repositories.VehiculoRepository;

import jakarta.transaction.Transactional;

@Service
public class ConductorService {
  @Autowired
  ConductorRepository conductorRepository;
  @Autowired
  VehiculoRepository vehiculoRepository;

  @Transactional
  public List<ConductorResponse> findAllAvailable() {
    List<ConductorEntity> conductores = conductorRepository.findByDisponibleTrue();
    List<ConductorResponse> response = conductores.stream()
        .map(conductor -> {
          VehiculoResponse vehiculoResponse = null;
          if (conductor.getVehiculo() != null) {
            VehiculoEntity vehiculo = conductor.getVehiculo();
            vehiculoResponse = VehiculoResponse.builder()
                .id(vehiculo.getId())
                .placa(vehiculo.getPlaca())
                .tipo(vehiculo.getTipo())
                .capacidadAsientos(vehiculo.getCapacidadAsientos())
                .asientosDisponibles(vehiculo.getAsientosDisponibles())
                .build();
          }
          return ConductorResponse.builder()
              .id(conductor.getId())
              .nombres(conductor.getNombres())
              .apellidos(conductor.getApellidos())
              .dni(conductor.getDni())
              .licencia(conductor.getLicencia())
              .disponible(conductor.getDisponible())
              .vehiculo(vehiculoResponse)
              .build();
        })
        .collect(Collectors.toList());

    return response;
  }

  @Transactional
  public ConductorEntity save(ConductorEntity conductor, Long vehiculoId) {
    if (conductor.getDisponible() == null) {
      conductor.setDisponible(true);
    }

    if (conductorRepository.existsByDni(conductor.getDni())) {
      throw new IllegalArgumentException("El DNI ya está registrado.");
    }

    if (conductorRepository.existsByLicencia(conductor.getLicencia())) {
      throw new IllegalArgumentException("La licencia ya está registrada.");
    }

    if (vehiculoId != null) {
      VehiculoEntity vehiculo = vehiculoRepository.findById(vehiculoId)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado"));
      conductor.setVehiculo(vehiculo);
      // vehiculo.setConductor(conductor);
    }

    return conductorRepository.save(conductor);
  }

  @Transactional
  public List<ConductorResponse> findAll() {
    List<ConductorEntity> conductores = (List<ConductorEntity>) conductorRepository.findAll();

    List<ConductorResponse> response = conductores.stream()
        .map(conductor -> {
          VehiculoResponse vehiculoResponse = null;
          if (conductor.getVehiculo() != null) {
            VehiculoEntity vehiculo = conductor.getVehiculo();
            vehiculoResponse = VehiculoResponse.builder()
                .id(vehiculo.getId())
                .placa(vehiculo.getPlaca())
                .tipo(vehiculo.getTipo())
                .capacidadAsientos(vehiculo.getCapacidadAsientos())
                .asientosDisponibles(vehiculo.getAsientosDisponibles())
                .build();
          }
          return ConductorResponse.builder()
              .id(conductor.getId())
              .nombres(conductor.getNombres())
              .apellidos(conductor.getApellidos())
              .dni(conductor.getDni())
              .licencia(conductor.getLicencia())
              .disponible(conductor.getDisponible())
              .vehiculo(vehiculoResponse)
              .build();
        })
        .collect(Collectors.toList());

    return response;
  }

  @Transactional
  public ResponseEntity<Void> deleteDriverById(Long id) {
    ConductorEntity conductor = conductorRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conductor no encontrado"));

    if (conductor.getVehiculo() != null) {
      VehiculoEntity vehiculo = conductor.getVehiculo();
      // vehiculo.setConductor(null);
      conductor.setVehiculo(null);

      if (vehiculo.getId() != null) {
        vehiculoRepository.save(vehiculo);
      }
    }
    conductorRepository.delete(conductor);
    return ResponseEntity.noContent().build();
  }

  @Transactional
  public ConductorEntity updateConductor(Long id, ConductorRequest conductorRequest) {
    ConductorEntity conductor = conductorRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conductor no encontrado"));

    if (conductorRequest.getDni() != null) {
      conductor.setDni(conductorRequest.getDni());
    }
    if (conductorRequest.getApellidos() != null) {
      conductor.setApellidos(conductorRequest.getApellidos());
    }
    if (conductorRequest.getNombres() != null) {
      conductor.setNombres(conductorRequest.getNombres());
    }
    if (conductorRequest.getLicencia() != null) {
      conductor.setLicencia(conductorRequest.getLicencia());
    }
    if (conductorRequest.getDisponible() != conductor.getDisponible()) {
      conductor.setDisponible(conductorRequest.getDisponible());
    }

    if (conductorRequest.getVehiculoId() != null) {
      VehiculoEntity vehiculo = vehiculoRepository.findById(conductorRequest.getVehiculoId())
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado"));

      conductor.setVehiculo(vehiculo);
      // vehiculo.setConductor(conductor);
    }

    return conductorRepository.save(conductor);
  }

}

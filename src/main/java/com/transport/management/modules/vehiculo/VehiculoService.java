package com.transport.management.modules.vehiculo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.management.modules.vehiculo.request.VehiculoRequest;
import com.transport.management.utils.abtractBase.BaseService;

import jakarta.transaction.Transactional;

@Service
public class VehiculoService extends BaseService<VehiculoEntity> {
  @Autowired
  VehiculoRepository vehiculoRepository;

  @Transactional
  public VehiculoEntity save(VehiculoRequest vehiculoRequest) {

    if (vehiculoRequest.getPlaca() == null || vehiculoRequest.getPlaca().isEmpty()) {
      throw new IllegalArgumentException("La placa es obligatoria.");
    }

    if (vehiculoRepository.existsByPlaca(vehiculoRequest.getPlaca())) {
      throw new IllegalArgumentException("La placa ya está registrada.");
    }

    VehiculoEntity vehiculo = VehiculoEntity.builder()
        .placa(vehiculoRequest.getPlaca())
        .tipo(vehiculoRequest.getTipo())
        .capacidadAsientos(vehiculoRequest.getCapacidadAsientos())
        .asientosDisponibles(vehiculoRequest.getCapacidadAsientos())
        .build();

    return vehiculoRepository.save(vehiculo);
  }

  @Transactional
  public List<VehiculoEntity> findVehiculosSinConductor() {
    return vehiculoRepository.findByConductorIsNull();
  }

  @Transactional
  public VehiculoEntity update(Long vehiculoId, VehiculoRequest vehiculoRequest) {
    VehiculoEntity vehiculo = vehiculoRepository.findById(vehiculoId)
        .orElseThrow(() -> new IllegalArgumentException("El vehículo no existe."));

    if (vehiculoRequest.getPlaca() != null && !vehiculoRequest.getPlaca().equals(vehiculo.getPlaca())) {
      if (vehiculoRepository.existsByPlaca(vehiculoRequest.getPlaca())) {
        throw new IllegalArgumentException("La nueva placa ya está registrada.");
      }
      vehiculo.setPlaca(vehiculoRequest.getPlaca());
    }

    if (vehiculoRequest.getTipo() != null) {
      vehiculo.setTipo(vehiculoRequest.getTipo());
    }

    if (vehiculoRequest.getCapacidadAsientos() != null) {
      vehiculo.setCapacidadAsientos(vehiculoRequest.getCapacidadAsientos());
    }

    if (vehiculoRequest.getAsientosDisponibles() != null) {
      if (vehiculoRequest.getAsientosDisponibles() > vehiculo.getCapacidadAsientos()) {
        throw new IllegalArgumentException(
            "Los asientos disponibles no pueden exceder la capacidad total de asientos.");
      }
      vehiculo.setAsientosDisponibles(vehiculoRequest.getAsientosDisponibles());
    }

    return vehiculoRepository.save(vehiculo);
  }

  @Transactional
  public void deleteVehiculo(Long vehiculoId) {
    VehiculoEntity vehiculo = vehiculoRepository.findById(vehiculoId)
        .orElseThrow(() -> new IllegalArgumentException("El vehículo no existe."));

    if (vehiculo.getConductor() != null) {
      String conductorNombre = vehiculo.getConductor().getNombres() + " " + vehiculo.getConductor().getApellidos();
      throw new IllegalArgumentException(
          "El vehículo no se puede eliminar porque está asignado al conductor: " + conductorNombre);
    }

    vehiculoRepository.delete(vehiculo);
  }
}
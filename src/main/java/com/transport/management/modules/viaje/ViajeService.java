package com.transport.management.modules.viaje;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.management.entities.ClienteEntity;
import com.transport.management.entities.RutaEntity;
import com.transport.management.enums.StatusViajeEnum;
import com.transport.management.modules.conductor.ConductorEntity;
import com.transport.management.modules.conductor.ConductorRepository;
import com.transport.management.modules.vehiculo.VehiculoEntity;
import com.transport.management.modules.vehiculo.VehiculoRepository;
import com.transport.management.modules.viaje.request.ViajeRequest;
import com.transport.management.repositories.ClienteRepository;
import com.transport.management.repositories.RutaRepository;
import com.transport.management.utils.abtractBase.BaseService;

import jakarta.transaction.Transactional;

@Service
public class ViajeService extends BaseService<ViajeEntity> {
  @Autowired
  ViajeRepository viajeRepository;

  @Autowired
  private RutaRepository rutaRepository;

  @Autowired
  private ConductorRepository conductorRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private VehiculoRepository vehiculoRepository;

  public List<ViajeEntity> findByFechaHoraSalidaAfter(LocalDateTime fechaHora) {
    return viajeRepository.findByFechaHoraSalidaAfter(fechaHora);
  }

  @Transactional
  public ViajeEntity cambiarEstado(Long viajeId, StatusViajeEnum nuevoEstado) {
    ViajeEntity viaje = viajeRepository.findById(viajeId)
        .orElseThrow(() -> new IllegalArgumentException("Viaje no encontrado"));

    if (viaje.getEstado().equals(nuevoEstado)) {
      throw new IllegalArgumentException("El estado ya es " + nuevoEstado);
    }

    if (viaje.getEstado().equals(StatusViajeEnum.COMPLETADO) || viaje.getEstado().equals(StatusViajeEnum.CANCELADO)) {
      throw new RuntimeException("El viaje ya está en un estado finalizado o cancelado. No se puede cambiar.");
    }

    if (viaje.getFechaHoraSalida().isBefore(LocalDateTime.now()) && !nuevoEstado.equals(StatusViajeEnum.CANCELADO)) {
      throw new RuntimeException(
          "No se puede cambiar el estado de un viaje cuya fecha de salida ya pasó, a menos que sea cancelado.");
    }

    viaje.setEstado(nuevoEstado);

    if (nuevoEstado.equals(StatusViajeEnum.COMPLETADO) || nuevoEstado.equals(StatusViajeEnum.CANCELADO)) {
      ConductorEntity conductor = viaje.getConductor();

      if (conductor == null || conductor.getVehiculo() == null) {
        throw new RuntimeException("El conductor no tiene un vehículo asignado.");
      }

      if (conductor != null && conductor.getVehiculo() != null) {
        VehiculoEntity vehiculo = conductor.getVehiculo();

        vehiculo.setAsientosDisponibles(vehiculo.getCapacidadAsientos());

        conductor.setDisponible(true);

        vehiculoRepository.save(vehiculo);
        conductorRepository.save(conductor);
      }
    }

    return viajeRepository.save(viaje);
  }

  @Transactional
  public ViajeEntity save(ViajeRequest viajeRequest) {
    // Validar que los datos del cliente estén completos
    if (viajeRequest.getClienteRequest().getDni() == null || viajeRequest.getClienteRequest().getDni().isEmpty()) {
      throw new IllegalArgumentException("El DNI del cliente es obligatorio");
    }

    if (viajeRequest.getClienteRequest().getNombres() == null
        || viajeRequest.getClienteRequest().getNombres().isEmpty()) {
      throw new IllegalArgumentException("El nombre del cliente es obligatorio");
    }

    // Validar que la ruta exista
    RutaEntity ruta = rutaRepository.findById(viajeRequest.getRutaId())
        .orElseThrow(() -> new IllegalArgumentException("Ruta no encontrada"));

    // Validar que el conductor exista
    ConductorEntity conductor = conductorRepository.findById(viajeRequest.getConductorId())
        .orElseThrow(() -> new IllegalArgumentException("Conductor no encontrado"));

    // Validar que el conductor tenga un vehículo asignado
    if (conductor.getVehiculo() == null) {
      throw new IllegalArgumentException("El conductor no tiene un vehículo asignado");
    }

    // Validar que haya asientos disponibles en el vehículo
    VehiculoEntity vehiculo = conductor.getVehiculo();
    if (vehiculo.getAsientosDisponibles() <= 0) {
      throw new IllegalArgumentException("No hay asientos disponibles en el vehículo del conductor");
    }

    // Validar que las fechas sean correctas
    if (viajeRequest.getFechaHoraSalida().isBefore(LocalDateTime.now())) {
      throw new IllegalArgumentException("La fecha de salida no puede ser en el pasado");
    }

    if (viajeRequest.getFechaHoraLlegadaEstimada().isBefore(viajeRequest.getFechaHoraSalida())) {
      throw new IllegalArgumentException("La fecha de llegada estimada no puede ser anterior a la fecha de salida");
    }

    // Validar el precio final
    double precioBase = ruta.getPrecioBase();
    double precioFinal = precioBase + (precioBase * 0.18);
    if (precioFinal <= 0) {
      throw new IllegalArgumentException("El precio final no puede ser cero o negativo");
    }

    ClienteEntity cliente = new ClienteEntity();
    cliente.setDni(viajeRequest.getClienteRequest().getDni());
    cliente.setNombres(viajeRequest.getClienteRequest().getNombres());
    cliente.setApellidos(viajeRequest.getClienteRequest().getApellidos());
    cliente.setEmail(viajeRequest.getClienteRequest().getEmail());
    cliente.setTelefono(viajeRequest.getClienteRequest().getTelefono());
    cliente.setDireccion(viajeRequest.getClienteRequest().getDireccion());

    cliente = clienteRepository.save(cliente);

    // Verificar si los asientos están disponibles y restarlos
    int asientosRestantes = vehiculo.getAsientosDisponibles() - 1;
    vehiculo.setAsientosDisponibles(asientosRestantes);

    if (asientosRestantes == 0) {
      conductor.setDisponible(false); // Marcar al conductor como no disponible si no hay asientos disponibles
    }

    vehiculoRepository.save(vehiculo);
    conductorRepository.save(conductor);

    // Crear el viaje
    ViajeEntity viaje = new ViajeEntity();
    viaje.setRuta(ruta);
    viaje.setConductor(conductor);
    viaje.setCliente(cliente);
    viaje.setFechaHoraSalida(viajeRequest.getFechaHoraSalida());
    viaje.setFechaHoraLlegadaEstimada(viajeRequest.getFechaHoraLlegadaEstimada());
    viaje.setPrecioFinal(precioFinal);

    viaje.crearViajeConTicket();

    return viajeRepository.save(viaje);
  }

}
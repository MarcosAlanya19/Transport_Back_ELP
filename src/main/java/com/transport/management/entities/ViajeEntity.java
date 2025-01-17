package com.transport.management.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import com.transport.management.modules.conductor.ConductorEntity;
import com.transport.management.modules.vehiculo.VehiculoEntity;
import com.transport.management.utils.abtractBase.BaseEntity;

@Entity
@Table(name = "viaje")
@Getter
@Setter
@NoArgsConstructor
public class ViajeEntity extends BaseEntity {
  @ManyToOne(optional = false)
  @JoinColumn(name = "ruta_id")
  private RutaEntity ruta;

  @ManyToOne(optional = false)
  @JoinColumn(name = "vehiculo_id")
  private VehiculoEntity vehiculo;

  @ManyToOne(optional = false)
  @JoinColumn(name = "conductor_id")
  private ConductorEntity conductor;

  @Column(nullable = false)
  private LocalDateTime fechaHoraSalida;

  @Column(nullable = false)
  private LocalDateTime fechaHoraLlegadaEstimada;
}

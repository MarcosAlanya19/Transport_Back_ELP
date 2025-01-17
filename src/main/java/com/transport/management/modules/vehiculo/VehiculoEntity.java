package com.transport.management.modules.vehiculo;

import com.transport.management.modules.conductor.ConductorEntity;
import com.transport.management.utils.abtractBase.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vehiculo")
public class VehiculoEntity extends BaseEntity {
  @Column(nullable = false, length = 50)
  private String placa;

  @Column(nullable = false, length = 20)
  private String tipo;

  @Column(nullable = false)
  private Integer capacidadAsientos;

  @Column(nullable = false)
  private Integer asientosDisponibles;

  @ManyToOne
  @JoinColumn(name = "conductor_id", nullable = true)
  private ConductorEntity conductor;
}
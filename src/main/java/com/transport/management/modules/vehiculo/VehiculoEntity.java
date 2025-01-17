package com.transport.management.modules.vehiculo;

import com.transport.management.utils.abtractBase.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehiculo")
@Getter
@Setter
@NoArgsConstructor
public class VehiculoEntity extends BaseEntity {

  @Column(nullable = false, length = 50)
  private String placa;

  @Column(nullable = false, length = 20)
  private String tipo; // Auto, Camioneta, Combi

  @Column(nullable = false)
  private Integer capacidadAsientos;

  @Column(nullable = false)
  private Integer asientosDisponibles;

  @Column(nullable = false)
  private boolean enServicio; // Si está asignado actualmente a un viaje
}

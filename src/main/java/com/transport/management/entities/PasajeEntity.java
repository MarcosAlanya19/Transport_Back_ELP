package com.transport.management.entities;

import com.transport.management.utils.abtractBase.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pasaje")
@Getter
@Setter
@NoArgsConstructor
public class PasajeEntity extends BaseEntity {
  @ManyToOne(optional = false)
  @JoinColumn(name = "cliente_id")
  private ClienteEntity cliente;

  @ManyToOne(optional = false)
  @JoinColumn(name = "viaje_id")
  private ViajeEntity viaje;

  @Column(nullable = false)
  private String categoriaVehiculo;

  @Column(nullable = false)
  private Double precioFinal;
}

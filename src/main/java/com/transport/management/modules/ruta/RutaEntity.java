package com.transport.management.modules.ruta;

import com.transport.management.utils.abtractBase.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ruta")
@Getter
@Setter
@NoArgsConstructor
public class RutaEntity extends BaseEntity {
  @Column(nullable = false, length = 100)
  private String origen;

  @Column(nullable = false, length = 100)
  private String destino;

  @Column(nullable = false)
  private Double distancia;

  @Column(nullable = false)
  private Double precioBase;
}

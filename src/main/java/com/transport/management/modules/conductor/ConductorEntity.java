package com.transport.management.modules.conductor;

import com.transport.management.utils.abtractBase.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "conductor")
@Getter
@Setter
@NoArgsConstructor
public class ConductorEntity extends BaseEntity {
  @Column(nullable = false, length = 100)
  private String nombre;

  @Column(nullable = false, length = 15, unique = true)
  private String licencia; // Número de licencia único

  @Column(nullable = false)
  private boolean disponible; // Si está libre para ser asignado a un viaje
}

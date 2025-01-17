package com.transport.management.modules.conductor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transport.management.entities.ViajeEntity;
import com.transport.management.modules.vehiculo.VehiculoEntity;
import com.transport.management.utils.abtractBase.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "conductor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConductorEntity extends BaseEntity {
  @Column(nullable = false, length = 8, unique = true)
  private String dni;

  @Column(nullable = false, length = 100)
  private String nombres;

  @Column(nullable = false, length = 100)
  private String apellidos;

  @Column(nullable = false, length = 15, unique = true)
  private String licencia;

  @Column(nullable = false)
  private Boolean disponible = true;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vehiculo_id", nullable = true)
  @JsonIgnore
  private VehiculoEntity vehiculo;

  @OneToMany(mappedBy = "conductor", fetch = FetchType.LAZY)
  @JsonIgnore
  private List<ViajeEntity> viajes;
}

package com.transport.management.modules.viaje;

import java.time.LocalDateTime;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.transport.management.entities.RutaEntity;
import com.transport.management.enums.StatusViajeEnum;
import com.transport.management.modules.cliente.ClienteEntity;
import com.transport.management.modules.conductor.ConductorEntity;
import com.transport.management.utils.abtractBase.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "viaje")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViajeEntity extends BaseEntity {
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ruta_id")
  private RutaEntity ruta;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "cliente_id")
  private ClienteEntity cliente;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "conductor_id")
  private ConductorEntity conductor;

  @Column(nullable = false)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private LocalDateTime fechaHoraSalida;

  @Column(nullable = false)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private LocalDateTime fechaHoraLlegadaEstimada;

  @Column(nullable = false)
  private Double precioFinal;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private StatusViajeEnum estado = StatusViajeEnum.PENDIENTE;

  @Column(nullable = false, unique = true)
  private String ticket;

  public void generarTicket() {
    Random random = new Random();
    this.ticket = String.valueOf(100000 + random.nextInt(900000));
  }

  public void crearViajeConTicket() {
    generarTicket();
  }
}
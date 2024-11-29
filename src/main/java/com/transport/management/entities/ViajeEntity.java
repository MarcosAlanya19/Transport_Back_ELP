package com.transport.management.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "viaje")
public class ViajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   /* @ManyToOne(optional = false)
    @JoinColumn(name = "ruta_id")
    private Ruta ruta;*/

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

    @Column(nullable = false)
    private LocalDateTime creadoEn;

    @Column(nullable = false)
    private LocalDateTime actualizadoEn;

    public ViajeEntity() {
    }

    /*public ViajeEntity(Long id, Ruta ruta, VehiculoEntity vehiculo, ConductorEntity conductor, LocalDateTime fechaHoraSalida, LocalDateTime fechaHoraLlegadaEstimada, LocalDateTime creadoEn, LocalDateTime actualizadoEn) {
        this.id = id;
        this.ruta = ruta;
        this.vehiculo = vehiculo;
        this.conductor = conductor;
        this.fechaHoraSalida = fechaHoraSalida;
        this.fechaHoraLlegadaEstimada = fechaHoraLlegadaEstimada;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }*/

    public VehiculoEntity getVehiculo() {
        return vehiculo;
    }

    public void setVehiculoEntity(VehiculoEntity vehiculo) {
        this.vehiculo = vehiculo;
    }

    public ConductorEntity getConductor() {
        return conductor;
    }

    public void setConductorEntity(ConductorEntity conductor) {
        this.conductor = conductor;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public LocalDateTime getFechaHoraLlegadaEstimada() {
        return fechaHoraLlegadaEstimada;
    }

    public void setFechaHoraLlegadaEstimada(LocalDateTime fechaHoraLlegadaEstimada) {
        this.fechaHoraLlegadaEstimada = fechaHoraLlegadaEstimada;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(LocalDateTime actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }
}

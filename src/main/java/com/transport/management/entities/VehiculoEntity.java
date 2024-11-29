package com.transport.management.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "vehiculo")
public class VehiculoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(nullable = false)
    private LocalDateTime creadoEn;

    @Column(nullable = false)
    private LocalDateTime actualizadoEn;

    public VehiculoEntity() {
    }

    public VehiculoEntity(Long id, String placa, String tipo, Integer asientosDisponibles, Integer capacidadAsientos, boolean enServicio, LocalDateTime creadoEn, LocalDateTime actualizadoEn) {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
        this.asientosDisponibles = asientosDisponibles;
        this.capacidadAsientos = capacidadAsientos;
        this.enServicio = enServicio;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCapacidadAsientos() {
        return capacidadAsientos;
    }

    public void setCapacidadAsientos(Integer capacidadAsientos) {
        this.capacidadAsientos = capacidadAsientos;
    }

    public boolean isEnServicio() {
        return enServicio;
    }

    public void setEnServicio(boolean enServicio) {
        this.enServicio = enServicio;
    }

    public Integer getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(Integer asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
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

package com.transport.management.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "conductor")
public class ConductorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 15, unique = true)
    private String licencia; // Número de licencia único

    @Column(nullable = false)
    private boolean disponible; // Si está libre para ser asignado a un viaje

    @Column(nullable = false)
    private LocalDateTime creadoEn;

    @Column(nullable = false)
    private LocalDateTime actualizadoEn;

    public ConductorEntity() {
    }

    public ConductorEntity(String nombre, Long id, String licencia, boolean disponible, LocalDateTime creadoEn, LocalDateTime actualizadoEn) {
        this.nombre = nombre;
        this.id = id;
        this.licencia = licencia;
        this.disponible = disponible;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
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

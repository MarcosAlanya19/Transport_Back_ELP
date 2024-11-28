package com.transport.management.entities;

import com.transport.management.utils.abtractBase.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne(optional = false)
    // @JoinColumn(name = "cliente_id")
    // private Cliente cliente;

    // @ManyToOne(optional = false)
    // @JoinColumn(name = "viaje_id")
    // private Viaje viaje;

    @Column(nullable = false)
    private String categoriaVehiculo;

    @Column(nullable = false)
    private Double precioFinal;
}

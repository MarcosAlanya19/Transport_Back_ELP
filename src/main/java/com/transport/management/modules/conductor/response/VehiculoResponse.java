package com.transport.management.modules.conductor.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehiculoResponse {
    private Long id;
    private String placa;
    private String tipo;
    private Integer capacidadAsientos;
    private Integer asientosDisponibles;
}

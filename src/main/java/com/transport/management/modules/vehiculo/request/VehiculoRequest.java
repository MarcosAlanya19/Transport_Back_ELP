package com.transport.management.modules.vehiculo.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehiculoRequest {
    private String placa;
    private String tipo;
    private Integer capacidadAsientos;
    private Integer asientosDisponibles;
}

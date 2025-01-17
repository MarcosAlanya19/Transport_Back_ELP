package com.transport.management.modules.conductor.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConductorResponse {
    private Long id;
    private String nombres;
    private String apellidos;
    private String dni;
    private String licencia;
    private boolean disponible;
    private VehiculoResponse vehiculo;
}

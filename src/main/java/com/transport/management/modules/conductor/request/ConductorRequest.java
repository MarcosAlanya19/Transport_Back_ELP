package com.transport.management.modules.conductor.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConductorRequest {
    private String dni;
    private String nombres;
    private String apellidos;
    private String licencia;
    private Boolean disponible;
    private Long vehiculoId;
}

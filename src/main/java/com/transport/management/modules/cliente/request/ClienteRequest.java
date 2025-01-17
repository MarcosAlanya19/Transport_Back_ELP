package com.transport.management.modules.cliente.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteRequest {
    private String dni;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private String direccion;
}

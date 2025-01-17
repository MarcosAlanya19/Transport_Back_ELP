package com.transport.management.modules.reniec.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReniecResponse {
    private String nombres;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String estadoCivil;

    private String sexo;

    private String fechaNacimiento;
}

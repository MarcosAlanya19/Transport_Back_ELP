package com.transport.management.modules.viaje.request;

import java.time.LocalDateTime;

import com.transport.management.modules.cliente.request.ClienteRequest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ViajeRequest {
    private Long rutaId;
    private Long conductorId;
    private LocalDateTime fechaHoraSalida;
    private LocalDateTime fechaHoraLlegadaEstimada;
    private ClienteRequest clienteRequest;
}
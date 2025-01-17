package com.transport.management.modules.ruta.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RutaRequest {
  private String origen;
  private String destino;
  private Double distancia;
  private Double precioBase;
}
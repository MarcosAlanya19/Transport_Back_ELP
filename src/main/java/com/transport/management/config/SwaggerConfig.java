package com.transport.management.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Transporte Interprovincial")
                        .description("Documentación de la API para la gestión de viajes y pasajes.")
                        .version("1.0"));
    }
}

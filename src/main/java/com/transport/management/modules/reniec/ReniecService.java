package com.transport.management.modules.reniec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.transport.management.modules.reniec.response.ReniecResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReniecService {

    @Value("${reniec.api.url}")
    private String apiUrl;

    @Value("${reniec.api.token}")
    private String apiToken;

    public ReniecResponse obtenerDatosPorDni(String dni) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "?numero=" + dni;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiToken);
        headers.set("Accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<ReniecResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity,
                    ReniecResponse.class);
            return response.getBody();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al obtener datos del DNI: " + dni, e);
        }
    }
}

package com.transport.management.modules.reniec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transport.management.modules.reniec.response.ReniecResponse;

@RestController
@RequestMapping("/reniec")
@CrossOrigin(origins = "*")
public class ReniecController {
    @Autowired
    ReniecService reniecService;

    @GetMapping("/dni/{dni}")
    public ResponseEntity<ReniecResponse> obtenerDatosPorDni(@PathVariable String dni) {
        try {
            ReniecResponse reniecResponse = reniecService.obtenerDatosPorDni(dni);

            if (reniecResponse != null) {
                return ResponseEntity.ok(reniecResponse);
            } else {
                return ResponseEntity.status(404).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
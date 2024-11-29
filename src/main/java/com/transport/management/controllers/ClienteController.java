package com.transport.management.controllers;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transport.management.entities.ClienteEntity;
import com.transport.management.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

   // private final ReniecService reniecService;
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
        //this.reniecService = reniecService;
    }

    @GetMapping
    public List<ClienteEntity> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ClienteEntity findById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public ClienteEntity save(@RequestBody ClienteEntity cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        clienteService.deleteById(id);
    }
  /*  @GetMapping("/buscar-dni/{dni}")
    public ResponseEntity<ClienteEntity> buscarPorDni(@PathVariable String dni) {
        ClienteEntity cliente = reniecService.obtenerDatosPorDni(dni);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}

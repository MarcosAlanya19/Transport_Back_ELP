package com.transport.management.modules.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
  @Autowired
  ClienteService clienteService;

  @GetMapping
  public ResponseEntity<List<ClienteEntity>> findAll() {
    List<ClienteEntity> vehiculos = clienteService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(vehiculos);
  }

  @PostMapping
  public ClienteEntity save(@RequestBody ClienteEntity cliente) {
    return clienteService.save(cliente);
  }
}

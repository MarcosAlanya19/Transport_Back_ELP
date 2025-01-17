package com.transport.management.modules.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.management.modules.cliente.request.ClienteRequest;
import com.transport.management.utils.abtractBase.BaseService;

@Service
public class ClienteService extends BaseService<ClienteEntity> {

  @Autowired
  ClienteRepository clienteRepository;

  public ClienteEntity save(ClienteRequest clienteRequest) {
    ClienteEntity cliente = new ClienteEntity();
    cliente.setDni(clienteRequest.getDni());
    cliente.setNombres(clienteRequest.getNombres());
    cliente.setApellidos(clienteRequest.getApellidos());
    cliente.setEmail(clienteRequest.getEmail());
    cliente.setTelefono(clienteRequest.getTelefono());
    cliente.setDireccion(clienteRequest.getDireccion());

    return clienteRepository.save(cliente);
  }

}
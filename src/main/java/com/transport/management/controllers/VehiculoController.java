package com.transport.management.controllers;

import com.transport.management.entities.VehiculoEntity;
import com.transport.management.services.VehiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public List<VehiculoEntity> findAll() {
        return vehiculoService.findAll();
    }

    @GetMapping("/{id}")
    public VehiculoEntity findById(@PathVariable Long id) {
        return vehiculoService.findById(id);
    }

    @PostMapping
    public VehiculoEntity save(@RequestBody VehiculoEntity vehiculo) {
        return vehiculoService.save(vehiculo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        vehiculoService.deleteById(id);
    }

    @GetMapping("/disponibles")
    public List<VehiculoEntity> findByEnServicio(@RequestParam boolean enServicio) {
        return vehiculoService.findByEnServicio(enServicio);
    }
}

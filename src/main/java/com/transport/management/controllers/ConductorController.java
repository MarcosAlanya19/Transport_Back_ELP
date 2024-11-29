package com.transport.management.controllers;

import com.transport.management.entities.ConductorEntity;
import com.transport.management.services.ConductorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conductores")
public class ConductorController {

    private final ConductorService conductorService;

    public ConductorController(ConductorService conductorService) {
        this.conductorService = conductorService;
    }


    @GetMapping
    public List<ConductorEntity> findAll() {
        return conductorService.findAll();
    }

    @GetMapping("/{id}")
    public ConductorEntity findById(@PathVariable Long id) {
        return conductorService.findById(id);
    }

    @PostMapping
    public ConductorEntity save(@RequestBody ConductorEntity conductor) {
        return conductorService.save(conductor);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        conductorService.deleteById(id);
    }

    @GetMapping("/disponibles")
    public List<ConductorEntity> findByDisponible(@RequestParam boolean disponible) {
        return conductorService.findByDisponible(disponible);
    }
}

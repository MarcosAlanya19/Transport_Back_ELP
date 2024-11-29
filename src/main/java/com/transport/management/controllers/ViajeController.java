package com.transport.management.controllers;

import com.transport.management.entities.ViajeEntity;
import com.transport.management.services.ViajeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/viajes")
public class ViajeController {

    private final ViajeService viajeService;

    public ViajeController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @GetMapping
    public List<ViajeEntity> findAll() {
        return viajeService.findAll();
    }

    @GetMapping("/{id}")
    public ViajeEntity findById(@PathVariable Long id) {
        return viajeService.findById(id);
    }

    @PostMapping
    public ViajeEntity save(@RequestBody ViajeEntity viaje) {
        return viajeService.save(viaje);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        viajeService.deleteById(id);
    }

    @GetMapping("/proximos")
    public List<ViajeEntity> findByFechaHoraSalidaAfter(@RequestParam LocalDateTime fechaHora) {
        return viajeService.findByFechaHoraSalidaAfter(fechaHora);
    }
}

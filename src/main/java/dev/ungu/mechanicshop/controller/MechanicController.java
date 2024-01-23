package dev.ungu.mechanicshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.ungu.mechanicshop.model.Mechanic;
import dev.ungu.mechanicshop.service.MechanicService;

@RestController
@CrossOrigin(origins = "*/*")
@RequestMapping("/api/v1/mechanic")
public class MechanicController {
    
    private MechanicService mechanicService;

    public MechanicController(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Mechanic>> getAllmechanics() {
        return ResponseEntity.ok(mechanicService.getAllMechanics());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Mechanic> getMechanicById(@PathVariable Long id) {
        return ResponseEntity.ok(mechanicService.getMechanicById(id));
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Mechanic> createMechanic(@RequestBody Mechanic mechanic) {
        return ResponseEntity.ok(mechanicService.createMechanic(mechanic));
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Mechanic> updateMechanic(@PathVariable Long id, @RequestBody Mechanic mechanic) {
        return ResponseEntity.ok(mechanicService.updateMechanic(id, mechanic));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteMechanic(@PathVariable Long id) {
        Mechanic mechanic = this.mechanicService.getMechanicById(id);
        this.mechanicService.deleteMechanic(mechanic);
    }
    
}

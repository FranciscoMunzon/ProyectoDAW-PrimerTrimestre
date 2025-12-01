package com.example.Proyectos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Proyectos.persistance.model.Developers;
import com.example.Proyectos.Service.DevelopersService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/developers")
@RequiredArgsConstructor
public class DevelopersController {

    private final DevelopersService developersService;

    @GetMapping
    public ResponseEntity<List<Developers>> getAll() {
        return ResponseEntity.ok(developersService.findAll());
    }

    @PostMapping
    public ResponseEntity<Developers> createDeveloper(@RequestBody Developers dev) {
        Developers created = developersService.createDeveloper(dev);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Developers> update(@PathVariable Integer id, @RequestBody Developers dev) {
        return ResponseEntity.ok(developersService.update(id, dev));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeveloper(@PathVariable Integer id) {
        developersService.deleteDeveloper(id);
        return ResponseEntity.noContent().build();
    }
}
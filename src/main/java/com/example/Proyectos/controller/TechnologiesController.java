package com.example.Proyectos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Proyectos.persistance.model.Technologies;
import com.example.Proyectos.Service.TechnologiesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/technologies")
@RequiredArgsConstructor
public class TechnologiesController {

    private final TechnologiesService techService;
    
    @GetMapping
    public ResponseEntity<List<Technologies>> getAll() {
        return ResponseEntity.ok(techService.findAll());
    }

    @PostMapping
    public ResponseEntity<Technologies> createTechnology(@RequestBody Technologies tech) {
        Technologies created = techService.createTechnology(tech);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Technologies> update(@PathVariable Integer id, @RequestBody Technologies tech) {
        return ResponseEntity.ok(techService.update(id, tech));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable Integer id) {
        techService.deleteTechnology(id);
        return ResponseEntity.noContent().build();
    }
}
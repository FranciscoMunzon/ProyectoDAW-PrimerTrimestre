package com.example.Proyectos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Proyectos.persistance.model.Technologies;
import com.example.Proyectos.Service.TechnologiesService;
import lombok.RequiredArgsConstructor;

@RestController                                          // Controlador REST
@RequestMapping("/api/v1/technologies")                 // Ruta base para tecnologías
@RequiredArgsConstructor
public class TechnologiesController {

    private final TechnologiesService techService;

    @GetMapping                                          // GET -> Obtener todas las tecnologías
    public ResponseEntity<List<Technologies>> getAll() {
        return ResponseEntity.ok(techService.findAll());
    }

    @PostMapping                                         // POST -> Crear tecnología
    public ResponseEntity<Technologies> createTechnology(@RequestBody Technologies tech) {
        Technologies created = techService.createTechnology(tech);
        return ResponseEntity.status(201).body(created); // 201 CREATED
    }

    @PutMapping("/{id}")                                 // PUT -> Modificar tecnología existente
    public ResponseEntity<Technologies> update(@PathVariable Integer id, @RequestBody Technologies tech) {
        return ResponseEntity.ok(techService.update(id, tech));
    }

    @DeleteMapping("/{id}")                              // DELETE -> Eliminar tecnología
    public ResponseEntity<Void> deleteTechnology(@PathVariable Integer id) {
        techService.deleteTechnology(id);
        return ResponseEntity.noContent().build();       // 204 NO CONTENT
    }
}
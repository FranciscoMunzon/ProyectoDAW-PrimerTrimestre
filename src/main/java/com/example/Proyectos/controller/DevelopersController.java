package com.example.Proyectos.controller;

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

    @PostMapping
    public ResponseEntity<Developers> createDeveloper(@RequestBody Developers dev) {
        Developers created = developersService.createDeveloper(dev);
        return ResponseEntity.status(201).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeveloper(@PathVariable Integer id) {
        developersService.deleteDeveloper(id);
        return ResponseEntity.noContent().build();
    }
}
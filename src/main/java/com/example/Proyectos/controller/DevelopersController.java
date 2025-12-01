package com.example.Proyectos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Proyectos.persistance.model.Developers;
import com.example.Proyectos.Service.DevelopersService;
import lombok.RequiredArgsConstructor;

@RestController                                         // Indica que esta clase es un controlador REST
@RequestMapping("/api/v1/developers")                   // Ruta base para todos los endpoints de developers
@RequiredArgsConstructor                                // Inyecta automáticamente las dependencias final
public class DevelopersController {

    private final DevelopersService developersService;   // Servicio que contiene la lógica de negocio

    @GetMapping                                          // GET -> Obtener todos los developers
    public ResponseEntity<List<Developers>> getAll() {
        // ResponseEntity.ok() devuelve un 200 OK con el contenido en el body
        return ResponseEntity.ok(developersService.findAll());
    }

    @PostMapping                                         // POST -> Crear un nuevo developer
    public ResponseEntity<Developers> createDeveloper(@RequestBody Developers dev) {
        Developers created = developersService.createDeveloper(dev);
        // status(201) indica que se creó correctamente el recurso
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")                                 // PUT -> Editar un developer existente
    public ResponseEntity<Developers> update(@PathVariable Integer id, @RequestBody Developers dev) {
        return ResponseEntity.ok(developersService.update(id, dev));
    }

    @DeleteMapping("/{id}")                              // DELETE -> Eliminar un developer
    public ResponseEntity<Void> deleteDeveloper(@PathVariable Integer id) {
        developersService.deleteDeveloper(id);
        // noContent() devuelve 204 -> borrado exitoso sin contenido en la respuesta
        return ResponseEntity.noContent().build();
    }
}

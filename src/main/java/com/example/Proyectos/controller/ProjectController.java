package com.example.Proyectos.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Proyectos.persistance.model.Project;
import com.example.Proyectos.Service.ProjectService;
import lombok.RequiredArgsConstructor;

@RestController                                         // Indica que es un controlador REST
@RequestMapping("/api/v1/projects")                     // Endpoint base para los proyectos
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping                                          // GET -> Obtener todos los proyectos
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{word}")                               // GET -> Buscar proyectos por palabra
    public ResponseEntity<List<Project>> getProjectsByWord(@PathVariable String word) {
        List<Project> projects = projectService.getProjectsByNameContaining(word);
        return ResponseEntity.ok(projects);
    }

    @PostMapping                                         // POST -> Crear un proyecto
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project created = projectService.createProject(project);
        return ResponseEntity.status(201).body(created); // 201 CREATED
    }

    @PutMapping("/{id}")                                 // PUT -> Editar proyecto existente
    public ResponseEntity<Project> updateProject(@PathVariable Integer id, @RequestBody Project project) {
        Project updated = projectService.updateProject(id, project);
        return ResponseEntity.ok(updated);               // 200 OK
    }

    @DeleteMapping("/{id}")                              // DELETE -> Eliminar proyecto
    public ResponseEntity<Void> deleteProject(@PathVariable Integer id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();       // 204 NO CONTENT
    }
}
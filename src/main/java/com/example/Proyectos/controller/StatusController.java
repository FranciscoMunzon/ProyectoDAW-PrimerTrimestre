package com.example.Proyectos.controller;

import com.example.Proyectos.persistance.model.Status;
import com.example.Proyectos.Service.StatusService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                                          // Controlador REST
@RequiredArgsConstructor
@RequestMapping("/api/v1/status")                        // Base de la API para status
@CrossOrigin(origins = "*")                              // Permite peticiones desde cualquier origen (CORS)
public class StatusController {

    private final StatusService statusService;

    @GetMapping                                          // GET -> Obtener todos los estados
    public ResponseEntity<List<Status>> getAll() {
        List<Status> statusList = statusService.getAllStatus();
        return ResponseEntity.ok(statusList);            // 200 OK con la lista de estados
    }
}
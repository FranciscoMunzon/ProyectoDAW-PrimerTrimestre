package com.example.Proyectos.controller;

import com.example.Proyectos.persistance.model.Status;
import com.example.Proyectos.Service.StatusService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/status")
@CrossOrigin(origins = "*")
public class StatusController {

    private final StatusService statusService;

    @GetMapping
    public ResponseEntity<List<Status>> getAll() {
        List<Status> statusList = statusService.getAllStatus();
        return ResponseEntity.ok(statusList);
    }
}
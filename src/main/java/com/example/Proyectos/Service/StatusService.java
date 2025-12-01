package com.example.Proyectos.Service;

import java.util.List;

import com.example.Proyectos.persistance.model.Status;

// Interfaz que define las operaciones relacionadas con los estados.
public interface StatusService {
    List<Status> getAllStatus();    // GET /status
}
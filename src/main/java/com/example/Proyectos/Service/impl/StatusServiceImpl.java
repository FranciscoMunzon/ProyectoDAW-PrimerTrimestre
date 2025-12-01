package com.example.Proyectos.Service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Proyectos.Service.StatusService;
import com.example.Proyectos.persistance.model.Status;
import com.example.Proyectos.persistance.repository.StatusRepository;

import lombok.RequiredArgsConstructor;


// Implementación de StatusService.
@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {

    // Repositorio para acceder a los datos de Status
    private final StatusRepository statusRepository;

    // Devuelve la lista completa de los estados existentes.
    @Override
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }
}
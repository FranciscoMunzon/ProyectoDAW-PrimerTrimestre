package com.example.Proyectos.Service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.Proyectos.persistance.model.Status;
import com.example.Proyectos.persistance.repository.StatusRepository;
import com.example.Proyectos.Service.StatusService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    @Override
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }
}
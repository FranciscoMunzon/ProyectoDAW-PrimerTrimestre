package com.example.Proyectos.Service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.Proyectos.Service.TechnologiesService;
import com.example.Proyectos.persistance.model.Technologies;
import com.example.Proyectos.persistance.repository.TechnologiesRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TechnologiesServiceImpl implements TechnologiesService {

    private final TechnologiesRepository techRepository;

    @Override
    public Technologies createTechnology(Technologies tech) {
        return techRepository.save(tech);
    }

    @Override
    public void deleteTechnology(Integer id) {
        techRepository.deleteById(id);
    }
}

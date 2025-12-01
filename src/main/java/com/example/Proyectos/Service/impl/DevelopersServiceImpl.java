package com.example.Proyectos.Service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.Proyectos.Service.DevelopersService;
import com.example.Proyectos.persistance.model.Developers;
import com.example.Proyectos.persistance.repository.DevelopersRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class DevelopersServiceImpl implements DevelopersService {

    private final DevelopersRepository developersRepository;

    @Override
    public Developers createDeveloper(Developers dev) {
        return developersRepository.save(dev);
    }

    @Override
    public void deleteDeveloper(Integer id) {
        developersRepository.deleteById(id);
    }
}

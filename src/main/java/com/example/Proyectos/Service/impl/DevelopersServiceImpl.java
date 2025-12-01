package com.example.Proyectos.Service.impl;

import java.util.List;

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
    public List<Developers> findAll() {
        return developersRepository.findAll();
    }

    @Override
    public Developers createDeveloper(Developers dev) {
        return developersRepository.save(dev);
    }

    @Override
    public Developers update(Integer id, Developers developer) {
        // si existe, se actualiza; si no, se crea con ese ID
        developer.setDevId(id);
        return developersRepository.save(developer);
    }

    @Override
    public void deleteDeveloper(Integer id) {
        developersRepository.deleteById(id);
    }
}

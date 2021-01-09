package com.victor.gym.util;

import java.util.List;


import org.springframework.data.repository.Repository;

import com.victor.gym.model.Persona;

public interface PersonaRepositorio extends Repository<Persona, Long>{
    List<Persona>findAll();
    Persona findById(Long id);
    Persona save(Persona p);
    void delete(Persona p);
}
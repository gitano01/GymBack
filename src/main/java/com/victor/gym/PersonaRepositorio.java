package com.victor.gym;

import java.util.List;


import org.springframework.data.repository.Repository;

public interface PersonaRepositorio extends Repository<Persona, Long>{
    List<Persona>findAll();
    Persona findById(Long id);
    Persona save(Persona p);
    void delete(Persona p);
}
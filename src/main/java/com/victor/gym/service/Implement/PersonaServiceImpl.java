package com.victor.gym.service.Implement;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.gym.model.Persona;
import com.victor.gym.service.PersonaService;
import com.victor.gym.util.PersonaRepositorio;

@Service
public class PersonaServiceImpl implements PersonaService{
	
    @Autowired
    private PersonaRepositorio repositorio;
    
    @Override
    public List<Persona> listar() {
        return repositorio.findAll();
    }

    @Override
    public Persona listarId(Long id) {
        return repositorio.findById(id) ;   }

    @Override
    public Persona add(Persona p) {
        return repositorio.save(p);
    }

    @Override
    public Persona edit(Persona p) {
        return repositorio.save(p);
    }

    @Override
    public Persona delete(Long id) {
        Persona p= repositorio.findById(id);
        if(p!=null){
            repositorio.delete(p);
        }
       return p;
    }
    
}
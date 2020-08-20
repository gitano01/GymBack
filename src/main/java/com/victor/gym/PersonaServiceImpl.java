package com.victor.gym;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
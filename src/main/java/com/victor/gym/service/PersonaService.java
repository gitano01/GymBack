package com.victor.gym.service;

import java.util.List;
import java.util.Optional;

import com.victor.gym.model.Persona;

public interface PersonaService {
	
	List<Persona>listar();
	Persona add(Persona p);
	Persona edit(Persona p);
	Persona delete(Long id);
	Persona listarId(Long id);
	
	

}

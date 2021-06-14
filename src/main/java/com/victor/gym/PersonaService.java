package com.victor.gym;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
	
	List<Persona>listar();
	Persona add(Persona p);
	Persona edit(Persona p);
	Persona delete(Long id);
	Persona buscarPersona(Long id);
	
	

}

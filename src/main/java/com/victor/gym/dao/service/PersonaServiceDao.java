package com.victor.gym.dao.service;

import java.util.List;

import com.victor.gym.model.Request.*;

public interface PersonaServiceDao {

	public List<Persona> listarPersonas();
	public Persona buscarPersona(int id);
	public String updatePersona(int id, Persona p);
   
}

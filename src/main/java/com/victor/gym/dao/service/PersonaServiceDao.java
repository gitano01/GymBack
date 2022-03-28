package com.victor.gym.dao.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.victor.gym.model.Request.*;


public interface PersonaServiceDao {

	//public List<Persona> listarPersonas();
	public String insertarPersona(PersonaRequest p);
	public Persona buscarPersona(int id);
	public String updatePersona(int id, Persona p);
	public String activarDesactivarPersona(int id, boolean val);
   
}

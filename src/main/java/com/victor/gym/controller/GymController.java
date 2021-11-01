package com.victor.gym.controller;

	
	import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
//  import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victor.gym.dao.implement.PersonaServiceImplement;
import com.victor.gym.model.Request.Persona;
import com.victor.gym.model.Response.Response;

	//@CrossOrigin(origins =; "http://localhost:4200", maxAge = 3600)
	@RestController
	@RequestMapping({"/personas"})
	public class GymController {

		@Autowired
		PersonaServiceImplement personaService;
		
		Response r;
		
		Logger log = LoggerFactory.getLogger(GymController.class);
	
		@GetMapping("/listarPersonas")
		public Response  listarPersonas() throws Exception{
			
			try {
			
				 if(personaService.listarPersonas() != null) {
			
					 
					 r = new Response();
					 r.setCodigo("200");
					 r.setMensaje("Opercion exitosa");
					 r.setResponse(personaService.listarPersonas());
					 
				 }else {
					 r = new Response();
					 r.setCodigo("400");
					 r.setMensaje("Recurso no encontrado");
					 
					 
				 }
				return r;
			}catch(Exception e ) {
				throw new Exception(e.getMessage());
			}
			
			    	
			
		}
	
		@GetMapping("/buscarPersona/{id}")
		public Persona obtenerPersona(@PathVariable("id") String id){
			
			  return  personaService.buscarPersona(Integer.valueOf(id));	
			
		}
}



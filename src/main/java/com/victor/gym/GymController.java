package com.victor.gym;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/personas"})

public class GymController {
	
	@Autowired
	PersonaService service;
	
	@GetMapping("/all")
	public Object listar(){
		
		ApiResponse goodResponse = new ApiResponse();
		ApiFailedResponse badResponse = new ApiFailedResponse();
		List<Persona> personas =  null;
		try {
			
			personas = service.listar();
			
			if(personas != null) {
			goodResponse.setCodigo(200);
			goodResponse.setMensaje("Opercion exitosa");
			goodResponse.setResponse(personas);
			
			return goodResponse;
			}else {
				badResponse.setCodigo(400);
				badResponse.setMensaje("Recurso no encontrado");				
				return badResponse;
			}
			
		}catch(Exception e) {
			
			badResponse.setCodigo(500);
			badResponse.setMensaje("Recurso no encontrado");
			badResponse.setInfo(e.getMessage());
			return badResponse;
		}
	}
	
	@GetMapping("/{id}")
	public Object buscarPersona(@PathVariable("id")Long id) {
		
		ApiResponse goodResponse = new ApiResponse();
		ApiFailedResponse badResponse = new ApiFailedResponse();
		Persona persona = null;
		
		try {
			
		persona = service.buscarPersona(id);
			
			if(persona != null) {
				
				goodResponse.setCodigo(200);
				goodResponse.setMensaje("Opercion exitosa");
				goodResponse.setResponse(persona);
				
				return goodResponse;
				
			}else {
				
				badResponse.setCodigo(400);
				badResponse.setMensaje("Recurso no encontrado");				
				return badResponse;
			}
		}catch(Exception e) {
			
			badResponse.setCodigo(500);
			badResponse.setMensaje("Recurso no encontrado");
			badResponse.setInfo(e.getMessage());
			return badResponse;
		}
		
		
		
	}
	
	
	
	
	
	
	
}

package com.victor.gym.controller;

	
	import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.victor.gym.dao.implement.PersonaServiceImplement;

import com.victor.gym.model.Request.Persona;
import com.victor.gym.model.Request.PersonaRequest;
import com.victor.gym.model.Response.ErrorResponse;
import com.victor.gym.model.Response.Response;
import com.victor.gym.utils.Validaciones;

	//@CrossOrigin(origins =; "http://localhost:4200", maxAge = 3600)
	@RestController
	@RequestMapping({"/gestion-personas"})
	public class GymController {

		@Autowired
		PersonaServiceImplement personaService;
		Response response = new Response();
		ErrorResponse error = new ErrorResponse();
				
		Logger log = LoggerFactory.getLogger(GymController.class);
	
		Validaciones valid = new Validaciones();

		@GetMapping("/listarPersonas")
		public ResponseEntity  listarPersonas() throws Exception{

			try {

				List<Persona> list = personaService.listarPersonas();

				if(list != null){
					response.setCodigo(200);
					response.setMensaje("Operación exitosa");
					response.setResultado(list);

					return new ResponseEntity<Response>(response, HttpStatus.OK);
				}else{
					error.setCodigo(404);
					error.setMensaje("Error en la operación");
					error.setDetalles("Recurso no encontrado");

					return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
				}


			}catch(Exception e ) {

				error.setMensaje("Error Interno");
				error.setCodigo(500);
				error.setDetalles(e.getMessage());
				return new  ResponseEntity<ErrorResponse>(error ,HttpStatus.INTERNAL_SERVER_ERROR);
			}



		}
	
		@GetMapping("/buscarPersona/{id}")
		public ResponseEntity obtenerPersona(@PathVariable("id") String id) throws Exception{
 
			try {	
			Persona  p = new Persona ();
		  
				if(valid.validaNumero(id) == false) {
					
					error.setCodigo(400);
					error.setMensaje("Error en la operacion");
					error.setDetalles("Error en parametro de entrada");
					
					return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
					
				}
		  		p = personaService.buscarPersona(Integer.valueOf(id));
		  		
		  		if(p != null) {
		  			
		  			response.setCodigo(200);
		  			response.setMensaje("Operación exitosa");
		  			response.setResultado(p);
		  			
		  			return new ResponseEntity<Response>(response, HttpStatus.OK);
					
		  			
		  		}else {
		  			
		  			error.setCodigo(404);
					error.setMensaje("Error en la operación");
					error.setDetalles("Recurso no encontrado");
					
					return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
		  			
		  		}
			}catch(Exception e) {

				error.setMensaje("Error Interno");
				error.setCodigo(500);
				error.setDetalles(e.getMessage());
				return new  ResponseEntity<ErrorResponse>(error ,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		  	
		}

		@PostMapping("/persona")
		public ResponseEntity insertarPersona(@RequestBody PersonaRequest p) throws Exception {

			try {

				String  insertado = personaService.insertarPersona(p);

					if(insertado != null){
						response.setMensaje("Operación exitosa");
						response.setCodigo(200);
						response.setResultado(insertado);
					return new ResponseEntity<Response>(response, HttpStatus.OK);
					}else{

						error.setMensaje("Error en la operacion");
						error.setCodigo(200);
						error.setDetalles("Error al insertar la informacion revise su información");
						return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
					}

			}catch (Exception e){

				error.setMensaje("Error Interno");
				error.setCodigo(500);
				error.setDetalles(e.getMessage());
				return new  ResponseEntity<ErrorResponse>(error ,HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
		
		@PostMapping("/{id}/activarDesactivarPersona/{valor}")
		public ResponseEntity activarPersona(@PathVariable("id") String id,@PathVariable("valor") String valor) throws Exception{
			try {
				String activar = personaService.activarDesactivarPersona(Integer.valueOf(id), Boolean.valueOf(valor));

				if(activar != null){
					response.setMensaje("Operación exitosa");
					response.setCodigo(200);
					response.setResultado(activar);
					return new ResponseEntity<Response>(response, HttpStatus.OK);
				}else{

					error.setMensaje("Error en la operacion");
					error.setCodigo(200);
					error.setDetalles("Error al activar el cliente");
					return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
				}

			}catch (Exception e){

				error.setMensaje("Error Interno");
				error.setCodigo(500);
				error.setDetalles(e.getMessage());
				return new  ResponseEntity<ErrorResponse>(error ,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
	
	
	}



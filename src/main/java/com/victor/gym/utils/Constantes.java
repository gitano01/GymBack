package com.victor.gym.utils;

enum Respuesta {

	   EXITO("200"),
	   BAD_REQUEST("400"),
	   UNAUTHORIZED("401"),
	   NOT_FOUND("404"),
	   SERVER_INTERNAL_ERROR("500");
	   
	   	private String respuesta;
	   	
	   	private Respuesta(String respuesta){
	   		this.respuesta = respuesta;
	   	}
	   	
	   	public String getRespuesta() {
	   		return respuesta;
	   	}
}

public class Constantes {

	
		
	
	
}

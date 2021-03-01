package com.victor.gym.model.Response;

public class Saludo {

	private String hola;
	
	public void setHola(String hola) {
		
		this.hola= hola;
		
		
	}
	
	public String getHola() {
		return hola;
	}
	
	@Override
	public String toString() {
		
		return "Hola: " + hola;
	}
	
}

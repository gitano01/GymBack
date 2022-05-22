package com.victor.gym.model.Request;

public class Persona {

	private int identificador;
    private String nombre;
    private String apellido;
    private String correo;
    private boolean activo; 
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int id) {
		this.identificador = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
    
    
}

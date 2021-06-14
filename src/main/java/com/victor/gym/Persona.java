package com.victor.gym;

import javax.persistence.*;


@Entity
@Table(name="persona")
public class Persona {

		@Id		
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		private Long id;
		@Column
		private String nombres;
		@Column
		private String apellido_paterno;
		@Column
		private String apellido_materno;
		@Column
		private String email;
		public Long getId() {
			return id;
		}
		public void setId(int id) {
			this.id = (long) id;
		}
		public String getNombres() {
			return nombres;
		}
		public void setNombres(String nombres) {
			this.nombres = nombres;
		}
		public String getApellido_paterno() {
			return apellido_paterno;
		}
		public void setApellido_paterno(String apellido_paterno) {
			this.apellido_paterno = apellido_paterno;
		}
		public String getApellido_materno() {
			return apellido_materno;
		}
		public void setApellido_materno(String apellido_materno) {
			this.apellido_materno = apellido_materno;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		} 
		
		
		
		
		
}

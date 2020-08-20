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
		private String apellidos;
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
		public String getApellidos() {
			return apellidos;
		}
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		} 
		
		
		
		
		
}

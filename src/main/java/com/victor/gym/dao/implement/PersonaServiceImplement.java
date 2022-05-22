package com.victor.gym.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import com.victor.gym.dao.service.PersonaServiceDao;
import com.victor.gym.jdbcConfig.JdbcConfig;
import com.victor.gym.model.Request.Persona;
import com.victor.gym.model.Request.PersonaRequest;




@Service
public class PersonaServiceImplement implements PersonaServiceDao{


JdbcConfig jdbcConfig = new JdbcConfig();


DataSource dataSourceConf = jdbcConfig.myPgSqlDataSource();
String sql = new String();
 
 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceConf);
 
 SimpleJdbcCall call;

 	public List<Persona> listarPersonas(){

		sql = "SELECT * FROM persona";

		List<Persona> lista = new ArrayList<>();

		lista =  this.jdbcTemplate.query(sql, new RowMapper<Persona>() {
		        @Override
		        public Persona mapRow(ResultSet rs, int i) throws SQLException {
		            Persona p = new Persona();
		            p.setIdentificador(rs.getInt("identificador"));
		            p.setNombre(rs.getString("nombre"));
		            p.setApellido(rs.getString("apellido"));
		            p.setCorreo(rs.getString("correo"));
		            p.setActivo(rs.getBoolean("activo"));
		            return p;
		        }
		    });

		return lista;
	 }

	 public String insertarPersona(PersonaRequest p){
		 
		  call = new SimpleJdbcCall(dataSourceConf).withFunctionName("insertarpersona");
		  MapSqlParameterSource in = new MapSqlParameterSource();
		  in.addValue("nombre", p.getNombre());
		  in.addValue("apellido", p.getApellido());
		  in.addValue("email", p.getCorreo());
		
		 return call.executeFunction(String.class, in);
		
		 
	 }



	 @SuppressWarnings("unchecked")
	public Persona buscarPersona(int id) {
		 
		 sql = "SELECT * FROM persona where identificador=" + id;
		 
		 List<Persona>  list = this.jdbcTemplate.query(sql, new RowMapper<Persona>() {
		        @Override
		        public Persona mapRow(ResultSet rs, int i) throws SQLException {
		            Persona p = new Persona();
		            p.setIdentificador(rs.getInt("identificador"));
		            p.setNombre(rs.getString("nombre"));
		            p.setApellido(rs.getString("apellido"));
		            p.setCorreo(rs.getString("correo"));
		            p.setActivo(rs.getBoolean("activo"));
		            return p;
		        }
		    });
		
		Persona persona = new Persona();
		
		int tam = list.size();
		
		if (list.size() == 0) {
			
			
			persona = null;
			
			return persona;
		}else {
		
		for(Persona elem: list) {
			
			persona.setIdentificador(elem.getIdentificador());
			persona.setNombre(elem.getNombre());
			persona.setApellido(elem.getApellido());
			persona.setCorreo(elem.getCorreo());
			persona.setActivo(elem.isActivo());
			
		}
		return persona;
		}
		
	 }  

	 
	 @SuppressWarnings("unchecked")
		public Persona getPersona(int id) {
		 
		 call = new SimpleJdbcCall(dataSourceConf).withFunctionName("buscarpersona");
		 MapSqlParameterSource in = new MapSqlParameterSource();
		 in.addValue("ide", id);
		 Map<String, Object> out = call.execute(in);
		 
		 Persona p = new Persona();
		 
		 p.setActivo((boolean) out.get("activo"));
		 p.setIdentificador((int)out.get("identificador"));
		 p.setNombre((String)out.get("nombre"));
		 p.setApellido((String)out.get("apellido"));
		 p.setCorreo((String)out.get("correo"));
		 
		 
		 return p;		
			
		 }  
	 
	  
	 

	 

	 public String updatePersona( int id,Persona p) {

		 return "Shidori";
	 }


	 public String activarDesactivarPersona(int id, boolean valor) {
		 
		 SimpleJdbcCall call = new SimpleJdbcCall(dataSourceConf).withFunctionName("activarDesactivarPersona");
		 
		 MapSqlParameterSource in = new MapSqlParameterSource();
		 in.addValue("in_id",id);
		 in.addValue("in_valor", valor);
		  		
		 return call.executeFunction(String.class, in);
	 }
	
	 
	 
		
		
		
		
		
	
	
}

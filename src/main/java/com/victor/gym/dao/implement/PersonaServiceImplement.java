package com.victor.gym.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import com.victor.gym.dao.service.PersonaServiceDao;
import com.victor.gym.jdbcConfig.JdbcConfig;
import com.victor.gym.model.Request.Persona;

@Service
public class PersonaServiceImplement implements PersonaServiceDao{


JdbcConfig jdbcConfig = new JdbcConfig();


DataSource dataSource = jdbcConfig.myPgSqlDataSource();
String sql = new String();
 
 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
 
	 public List<Persona> listarPersonas(){
		 
		sql = "SELECT * FROM  mostrarpersonas()";
		 
		 return this.jdbcTemplate.query(sql, new RowMapper<Persona>() {
		        @Override
		        public Persona mapRow(ResultSet rs, int i) throws SQLException {
		            Persona p = new Persona();
		            p.setIdentificador(rs.getInt("identificador"));
		            p.setNombre(rs.getString("nombre"));
		            p.setApellido(rs.getString("apellido"));
		            p.setCorreo(rs.getString("correo"));
		            return p;
		        }
		    });
		 
	 }
 
	 public Persona buscarPersona(int id) {
		 
		 SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
                 .withFunctionName("buscarpersona");
                 
		 
		 
		 	SqlParameterSource in = new MapSqlParameterSource().addValue("ide", id);
		    Map<String, Object> out = simpleJdbcCall.execute(in);
		 
		    Persona p = new Persona();
            p.setIdentificador((int )out.get("identificador"));
            p.setNombre((String) out.get("nombre"));
            p.setApellido((String) out.get("apellido"));
            p.setCorreo( (String) out.get("correo"));
            return p;
		      
//		 return (Persona) this.jdbcTemplate.query(sql, new RowMapper<Persona>() {
//		        @Override
//		        public Persona mapRow(ResultSet rs, int i) throws SQLException {
//		            Persona p = new Persona();
//		            p.setIdentificador(rs.getInt("identificador"));
//		            p.setNombre(rs.getString("nombre"));
//		            p.setApellido(rs.getString("apellido"));
//		            p.setCorreo(rs.getString("correo"));
//		            return p;
//		        }
//		    });
	 }
 
	 public String updatePersona( int id,Persona p) {
		 
		 return "Shidori";
	 }
		
		
		
		
		
		
		
	
	
}

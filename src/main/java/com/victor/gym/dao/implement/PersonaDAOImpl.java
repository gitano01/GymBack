package com.victor.gym.dao.implement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import com.victor.gym.dao.service.PersonaDAO;
import com.victor.gym.model.Request.Persona;


public class PersonaDAOImpl implements PersonaDAO{

	private SimpleJdbcCall simpleJdbcCall;	

	
	public void setDataSource(DataSource dataSource)
	{
		this.simpleJdbcCall = new SimpleJdbcCall(dataSource).withFunctionName("mostrarpersonas")
				.returningResultSet("persona", BeanPropertyRowMapper.newInstance(Persona.class));
	}

	public List<Persona> mostrarPersonas_SP()
	{
		Map m = simpleJdbcCall.execute(new HashMap<String, Object>(0));
		return (List<Persona>) m.get("persona");
	}
	
}

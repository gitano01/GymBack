package com.victor.gym.dao.service;

import com.victor.gym.model.Request.Usuario;
import com.victor.gym.model.Response.Response;

public interface UsuarioServiceDao {

	public Response getUser(Usuario usuario);
	
}

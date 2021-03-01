package service.cliente;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.victor.gym.model.Response.Saludo;

public class ClienteService implements ClienteInterface{

	Logger log = LoggerFactory.getLogger(ClienteService.class);
	
	public Saludo obtenerSaludos(){
		
		log.info("Iniciado proceso de Saludo");
		
		Saludo respuesta = new Saludo();
		
		respuesta.setHola("Hola perra");
		return respuesta;
	}
}

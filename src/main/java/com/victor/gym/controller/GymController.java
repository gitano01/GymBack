package com.victor.gym.controller;

	
	import java.util.List;

import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
//  import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import com.victor.gym.model.Request.Persona;

	//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@RestController
	@RequestMapping({"/personas"})
	public class GymController {

		Logger log = LoggerFactory.getLogger(GymController.class);
	
	
		@GetMapping("/test")
		public String saludo() {
			return "Hola We";
		}
	
}



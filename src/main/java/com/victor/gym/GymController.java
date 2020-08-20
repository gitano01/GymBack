package com.victor.gym;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@RestController
	@RequestMapping({"/personas"})

	public class GymController {
		
		@Autowired
		PersonaService service;
		
		@GetMapping("/all")
		public List<Persona>listar(){
			
			System.out.println("Aqui entre perro");
			return service.listar();
		}
		@GetMapping("/{id}")
		public Persona listarId(@PathVariable("id")Long id) {
			
			
			System.out.println("Vale cheto");
			return service.listarId(id);
		}
		
		@PutMapping(path = {"/{id}"})
		public Persona editar(@RequestBody Persona p,@PathVariable("id") int id){
		        p.setId(id);
		        return service.edit(p);
		    }
		
		@DeleteMapping(path = {"/{id}"})
		public Persona delete(@PathVariable("id") Long  id){
		        return service.delete(id);
		    }
		
	
	
	
	
	
}



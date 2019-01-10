package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import entity.Rol;
import service.RolServiceIface;
import util.Constants;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/workder_api")
public class RolController {
	
	@Autowired
	private RolServiceIface rolService;
	
	@Autowired
	private Constants constants;
	
	
	/*-----------------------METHODS-----------------------*/
	
	@GetMapping("/rols")
	public List<Rol> index(){
		return rolService.findAll();
	}
	
	@GetMapping("/rols/{id}")
	public Rol show(@PathVariable Long id) {
		return rolService.findById(id);
	}
	
	@PostMapping("/rols")
	@ResponseStatus(HttpStatus.CREATED)
	public Rol create(@RequestBody Rol rol) {
		return rolService.save(rol);
	}
	
	@PutMapping("/rols/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Rol update (@RequestBody Rol rol, @PathVariable Long id) {
		Rol r = rolService.findById(id);
		
		r.setName(rol.getName());
		r.setDescription(rol.getDescription());
		
		return rolService.save(r);
	}
	
	@DeleteMapping("/rols/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		rolService.delete(id);
	}

}

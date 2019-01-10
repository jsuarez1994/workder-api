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
import entity.Position;
import service.PositionServiceIface;
import util.Constants;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/workder_api")
public class PositionController {
	
	@Autowired
	private PositionServiceIface positionService;
	
	@Autowired
	private Constants constants;
	
	
	/*-----------------------METHODS-----------------------*/
	
	@GetMapping("/positions")
	public List<Position> index(){
		return positionService.findAll();
	}
	
	@GetMapping("/positions/{id}")
	public Position show(@PathVariable Long id) {
		return positionService.findById(id);
	}
	
	@PostMapping("/positions")
	@ResponseStatus(HttpStatus.CREATED)
	public Position create(@RequestBody Position position) {
		return positionService.save(position);
	}
	
	@PutMapping("/positions/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Position update (@RequestBody Position position, @PathVariable Long id) {
		Position r = positionService.findById(id);
		
		r.setName(position.getName());
		r.setDescription(position.getDescription());
		
		return positionService.save(r);
	}
	
	@DeleteMapping("/positions/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		positionService.delete(id);
	}

}

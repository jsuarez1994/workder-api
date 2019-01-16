package com.workderapi.controllers;

import java.util.Date;
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

import com.workderapi.entity.Sector;
import com.workderapi.services.SectorServiceIface;
import com.workderapi.util.Constants;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/workder_api")
public class SectorController {
	
	@Autowired
	SectorServiceIface sectorService;
		
	
	/*-----------------------METHODS-----------------------*/
	
	@GetMapping("/sectors")
	public List<Sector> index(){
		return sectorService.findAll();
	}
	
	@GetMapping("/sectors/{id}")
	public Sector show(@PathVariable("id") Long id) {
		return sectorService.findById(id);
	}
	
	@PostMapping("/sectors")
	@ResponseStatus(HttpStatus.CREATED)
	public Sector create(@RequestBody Sector sector) {
		return sectorService.save(sector);
	}
	
	@PutMapping("/sectors/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Sector update (@RequestBody Sector sector, @PathVariable("id") Long id) {
		Sector sec = sectorService.findById(id);
		
		sec.setName(sector.getName());
		sec.setDescription(sector.getDescription());
		
		return sectorService.save(sec);
	}
	
	@DeleteMapping("/sectors/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		sectorService.delete(id);
	}

}

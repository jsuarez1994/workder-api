package com.workderapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workderapi.entity.Sector;
import com.workderapi.services.SectorServiceIface;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/workder_api")
public class SectorController {
	
	@Autowired
	SectorServiceIface sectorService;
		
	
	/*-----------------------METHODS-----------------------*/
	
	@RequestMapping(value = "/sectors", method = RequestMethod.GET)
	public List<Sector> index(){
		return sectorService.findAll();
	}
	
	@RequestMapping(value = "/sector/{id}", method = RequestMethod.GET)
	public Sector show(@PathVariable("id") Long id) {
		return sectorService.findById(id);
	}
	
	@RequestMapping(value = "/sector", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Sector create(@RequestBody Sector sector) {
		
		Sector sectorToSave;
		Sector sectorExit;
		
		if( sector.getId() != null ) { //UPDATE
			sectorToSave = sectorService.findById(sector.getId());
			
			if(sector.getName() != null) {
				sectorToSave.setName(sector.getName());
			}
			
			if(sector.getDescription() != null) {
				sectorToSave.setDescription(sector.getDescription());
			}
			
			if(sector.getCompany() != null) {
				sectorToSave.setCompany(sector.getCompany());
			}
			
			sectorExit = sectorService.save(sectorToSave);
			
		} else { //SAVE			
			sectorExit = sectorService.save(sector);
		}
		
		return sectorExit;
		
	}
	
	@RequestMapping(value = "/sector/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		sectorService.delete(id);
	}

}

package com.workderapi.controllers;

import java.sql.Date;
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

import com.workderapi.entity.Position;
import com.workderapi.services.PositionServiceIface;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/workder_api")
public class PositionController {
	
	@Autowired
	PositionServiceIface positionService;
	
	
	/*-----------------------METHODS-----------------------*/
	
	@RequestMapping(value = "/positions", method = RequestMethod.GET)
	public List<Position> index(){
		return positionService.findAll();
	}
	
	@RequestMapping(value = "/position/{id}", method = RequestMethod.GET)
	public Position show(@PathVariable("id") Long id) {
		return positionService.findById(id);
	}
	
	@RequestMapping(value = "/position", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Position create(@RequestBody Position position) {
		
		Position positionToSave;
		Position positionExit;
		
		if( position.getId() != null ) { //UPDATE
			positionToSave = positionService.findById(position.getId());
			
			if(position.getName() != null) {
				positionToSave.setName(position.getName());
			}
			
			if(position.getDescription() != null) {
				positionToSave.setDescription(position.getDescription());
			}
			if(position.getUsers() != null) {
				positionToSave.setUsers(position.getUsers());
			}
			
			positionExit = positionService.save(positionToSave);
			
		} else { //SAVE			
			positionExit = positionService.save(position);
		}
		
		return positionExit;
		
	}
	
	
	@RequestMapping(value = "/position/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		positionService.delete(id);
	}

}

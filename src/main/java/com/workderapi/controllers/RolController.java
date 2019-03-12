package com.workderapi.controllers;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workderapi.entity.Rol;
import com.workderapi.entity.Rol;
import com.workderapi.services.RolServiceIface;
import com.workderapi.util.Constants;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/workder_api")
public class RolController {
	
	@Autowired
	RolServiceIface rolService;
	
	
	/*-----------------------METHODS-----------------------*/
	
	@RequestMapping(value = "/rols", method = RequestMethod.GET)
	public List<Rol> index(){
		return rolService.findAll();
	}
	
	@RequestMapping(value = "/rol/{id}", method = RequestMethod.GET)
	public Rol show(@PathVariable("id") Long id) {
		return rolService.findById(id);
	}
	
	@RequestMapping(value = "/rol", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Rol create(@RequestBody Rol rol) {
		
		Rol rolToSave;
		Rol rolExit;
		
		if( rol.getId() != null ) { //UPDATE
			rolToSave = rolService.findById(rol.getId());
			
			if(rol.getName() != null) {
				rolToSave.setName(rol.getName());
			}
			
			if(rol.getDescription() != null) {
				rolToSave.setDescription(rol.getDescription());
			}
			
			if(rol.getUsers() != null) {
				rolToSave.setUsers(rol.getUsers());
			}
			
			rolExit = rolService.save(rolToSave);
			
		} else { //SAVE			
			rolExit = rolService.save(rol);
		}
		
		return rolExit;
		
	}
	
	@RequestMapping(value = "/rol/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		rolService.delete(id);
	}

}

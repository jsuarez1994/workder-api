package com.workderapi.controllers;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workderapi.entity.User;
import com.workderapi.services.UserServiceIface;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/workder_api")
public class UserController {

	@Autowired
	UserServiceIface userService;
		
	
	/*-----------------------METHODS-----------------------*/
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> index(){
		return userService.findAll();
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User show(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		
		User userToSave;
		User userExit;
		
		if( user.getId() != null ) { //UPDATE
			userToSave = userService.findById(user.getId());
			
			if(user.getName() != null) {
				userToSave.setName(user.getName());
			}
			
			if(user.getSurname() != null) {
				userToSave.setSurname(user.getSurname());
			}
			
			if(user.getPathPhoto() != null) {
				userToSave.setPathPhoto(user.getPathPhoto());
			}
			
			if(user.getEmail() != null) {
				userToSave.setEmail(user.getEmail());
			}
			
			if(user.getPassword() != null) {
				userToSave.setPassword(user.getPassword());
			}
			
			if(user.getRol() != null) {
				userToSave.setRol(user.getRol());
			}
			
			if(user.getPosition() != null) {
				userToSave.setPosition(user.getPosition());
			}
			
			if(user.getCompany() != null) {
				userToSave.setCompany(user.getCompany());
			}
			
			if(user.getActivated() != null) {
				userToSave.setActivated(user.getActivated());
			}
			
			userToSave.setUpdateAt(new Date());
			userExit = userService.save(userToSave);
			
		} else { //SAVE			
			user.setCreateAt(new Date());
			user.setPassword(DigestUtils.sha256Hex(user.getPassword()));//Password hashet sha256
			userExit = userService.save(user);
		}
		
		return userExit;
		
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		userService.delete(id);
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public User login(@RequestBody User user) {
		return userService.login(user.getEmail(), DigestUtils.sha256Hex(user.getPassword()));
		
	}
	

}

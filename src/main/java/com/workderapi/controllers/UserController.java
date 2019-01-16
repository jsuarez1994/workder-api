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

import com.workderapi.entity.User;
import com.workderapi.services.UserServiceIface;
import com.workderapi.util.Constants;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/workder_api")
public class UserController {

	@Autowired
	UserServiceIface userService;
		
	
	/*-----------------------METHODS-----------------------*/
	
	@GetMapping("/users")
	public List<User> index(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User show(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	
//	@PostMapping("/users")
//	@ResponseStatus(HttpStatus.CREATED)
//	public User create(@RequestBody User user) {
//		user.setCreateAt(new Date());
//		user.setActivated(true);
//		return userService.save(user);
//	}
	
	@PutMapping("/users/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public User update (@RequestBody User user, @PathVariable("id") Long id) {
		User us = userService.findById(id);
		
		us.setName(user.getName());
		us.setSurname(user.getSurname());
		us.setUpdateAt(new Date());
		
		
		return userService.save(us);
	}
	
	@DeleteMapping("/users/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		userService.delete(id);
	}
	

}

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

import com.workderapi.entity.Company;
import com.workderapi.services.CompanyServiceIface;
import com.workderapi.util.Constants;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/workder_api")
public class CompanyController {
	
	@Autowired
	CompanyServiceIface companyService;
	
	
	
	/*-----------------------METHODS-----------------------*/
	
	@GetMapping("/companys")
	public List<Company> index(){
		return companyService.findAll();
	}
	
	@GetMapping("/companys/{id}")
	public Company show(@PathVariable("id") Long id) {
		return companyService.findById(id);
	}
	
	@PostMapping("/companys")
	@ResponseStatus(HttpStatus.CREATED)
	public Company create(@RequestBody Company company) {
		return companyService.save(company);
	}
	
	@PutMapping("/companys/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Company update (@RequestBody Company company, @PathVariable("id") Long id) {
		Company r = companyService.findById(id);
		
		r.setUpdateAt(new Date());
		r.setName(company.getName());
		r.setDescription(company.getDescription());
		r.setSector(company.getSector());
		r.setWeb(company.getWeb());
		r.setAddress(company.getAddress());
		
		return companyService.save(r);
	}
	
	@DeleteMapping("/companys/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		companyService.delete(id);
	}

}

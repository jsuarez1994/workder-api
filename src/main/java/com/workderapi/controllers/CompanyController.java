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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workderapi.entity.Company;
import com.workderapi.entity.Company;
import com.workderapi.services.CompanyServiceIface;
import com.workderapi.util.Constants;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/workder_api")
public class CompanyController {
	
	@Autowired
	CompanyServiceIface companyService;
	
	/*-----------------------METHODS-----------------------*/
	
	@RequestMapping(value = "/companys", method = RequestMethod.GET)
	public List<Company> index(){
		return companyService.findAll();
	}
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
	public Company show(@PathVariable("id") Long id) {
		return companyService.findById(id);
	}
	
	
	@RequestMapping(value = "/company", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Company create(@RequestBody Company company) {
		
		Company companyToSave;
		Company companyExit;
		
		if( company.getId() != null ) { //UPDATE
			companyToSave = companyService.findById(company.getId());
			
			if(company.getName() != null) {
				companyToSave.setName(company.getName());
			}
			
			if(company.getDescription() != null) {
				companyToSave.setDescription(company.getDescription());
			}
			
			if(company.getAddress() != null) {
				companyToSave.setAddress(company.getAddress());
			}
			
			if(company.getSector() != null) {
				companyToSave.setSector(company.getSector());
			}
			
			if(company.getWeb() != null) {
				companyToSave.setWeb(company.getWeb());
			}
			
			companyToSave.setUpdateAt(new Date());
			companyExit = companyService.save(companyToSave);
			
		} else { //SAVE			
			company.setCreateAt(new Date());
			companyExit = companyService.save(company);
		}
		
		return companyExit;
		
	}
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		companyService.delete(id);
	}

}

package com.workderapi.services;

import java.util.List;

import com.workderapi.entity.Company;

public interface CompanyServiceIface {
	
	public List<Company> findAll();

	public Company save(Company Company);

	public void delete(Long id);

	public Company findById(Long id);

}

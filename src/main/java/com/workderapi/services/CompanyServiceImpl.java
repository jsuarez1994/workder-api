package com.workderapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workderapi.daos.CompanyDaoIface;
import com.workderapi.entity.Company;

@Service
public class CompanyServiceImpl implements CompanyServiceIface {

	@Autowired
	private CompanyDaoIface companyDao;

	/**
	 * Name:		finAll()
	 * Params:		None
	 * Description:	Return all Company of data base
	 * */
	@Override
	public List<Company> findAll() {
		return (List<Company>)companyDao.findAll();
	}

	/**
	* Name:			save(Company Company)
	* Params:		company Bean Company
	* Description:	Save the bean of params
	* */
	@Override
	public Company save(Company company) {
		return (Company)companyDao.save(company);
	}

	/**
	* Name:			delete(Long id)
	* Params:		id Type Long
	* Description:	Delete Company by id
	* */
	@Override
	public void delete(Long id) {
		companyDao.deleteById(id);
	}

	/**
	* Name:			findById(Long id)
	* Params:		id Type Long
	* Description:	Return Company Bean by id or null if not exists.
	* */
	@Override
	public Company findById(Long id) {
		return companyDao.findById(id).orElse(null);
	}

}

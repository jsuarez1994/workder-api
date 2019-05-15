package com.workderapi.controllers;

import java.util.Date;
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

import com.workderapi.entity.Company;
import com.workderapi.services.CompanyServiceIface;
import com.workderapi.util.Constants.ConstantsWS;

@CrossOrigin(origins = ConstantsWS.WS_DNS)
@RestController
@RequestMapping(ConstantsWS.WS_BASE_WORKDER_API)
public class CompanyController {

	@Autowired
	CompanyServiceIface companyService;

	/*-----------------------METHODS-----------------------*/

	/**
	* Name:			index()
	* @Params:		
	* Description:	Retorna todas las entidades Company
	* */
	@RequestMapping(value = ConstantsWS.WS_COMPANYS, method = RequestMethod.GET)
	public List<Company> index() {
		return companyService.findAll();
	}

	/**
	* Name:			show()
	* @Params:		id
	* Description:	Retorna una entidad Company a partir de su id
	* */
	@RequestMapping(value = ConstantsWS.WS_COMPANY_ID, method = RequestMethod.GET)
	public Company show(@PathVariable(ConstantsWS.ID) Long id) {
		return companyService.findById(id);
	}

	/**
	* Name:			create()
	* @Params:		company
	* Description:	Crea/Actualiza una company
	* */
	@RequestMapping(value = ConstantsWS.WS_COMPANY, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Company create(@RequestBody Company company) {

		Company companyToSave;
		Company companyExit;

		if (company.getId() != null) { // UPDATE
			companyToSave = companyService.findById(company.getId());

			if (company.getName() != null) {
				companyToSave.setName(company.getName());
			}

			if (company.getDescription() != null) {
				companyToSave.setDescription(company.getDescription());
			}

			if (company.getAddress() != null) {
				companyToSave.setAddress(company.getAddress());
			}

			if (company.getSector() != null) {
				companyToSave.setSector(company.getSector());
			}

			if (company.getWeb() != null) {
				companyToSave.setWeb(company.getWeb());
			}

			companyToSave.setUpdateAt(new Date());
			companyExit = companyService.save(companyToSave);

		} else { // SAVE
			company.setCreateAt(new Date());
			companyExit = companyService.save(company);
		}

		return companyExit;

	}

	/**
	* Name:			delete()
	* @Params:		id
	* Description:	Elimina una company por su id
	* */
	@RequestMapping(value = ConstantsWS.WS_COMPANY_ID, method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(ConstantsWS.ID) Long id) {
		companyService.delete(id);
	}

}

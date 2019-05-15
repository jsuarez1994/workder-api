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

import com.workderapi.entity.Rol;
import com.workderapi.services.RolServiceIface;
import com.workderapi.util.Constants.ConstantsWS;

@CrossOrigin(origins= ConstantsWS.WS_DNS)
@RestController
@RequestMapping(ConstantsWS.WS_BASE_WORKDER_API)
public class RolController {
	
	@Autowired
	RolServiceIface rolService;
	
	
	/*-----------------------METHODS-----------------------*/
	
	/**
	* Name:			index()
	* @Params:		
	* Description:	Retorna todas las entidades Rol de BD
	* */
	@RequestMapping(value = ConstantsWS.WS_ROL, method = RequestMethod.GET)
	public List<Rol> index(){
		return rolService.findAll();
	}
	
	/**
	 * Name:		show()
	 * @Params:		id
	 * Description:	Retorna un rol a partir de su id
	 * */
	@RequestMapping(value = ConstantsWS.WS_ROL_ID, method = RequestMethod.GET)
	public Rol show(@PathVariable(ConstantsWS.ID) Long id) {
		return rolService.findById(id);
	}
	
	/**
	 * Name:		create()
	 * @Params:		position
	 * Description:	Crea/Actualiza una entidad Rol
	 * */
	@RequestMapping(value = ConstantsWS.WS_ROL, method = RequestMethod.POST)
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
	
	/**
	 * Name:		delete()
	 * @Params:		id
	 * Description:	Elimina una entidad Rol a partir de su id.
	 * */
	@RequestMapping(value = ConstantsWS.WS_ROL_ID, method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(ConstantsWS.ID) Long id) {
		rolService.delete(id);
	}

}

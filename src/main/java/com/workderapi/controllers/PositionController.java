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

import com.workderapi.entity.Position;
import com.workderapi.services.PositionServiceIface;
import com.workderapi.util.Constants.ConstantsWS;

@CrossOrigin(origins = ConstantsWS.WS_DNS)
@RestController
@RequestMapping(ConstantsWS.WS_BASE_WORKDER_API)
public class PositionController {

	@Autowired
	PositionServiceIface positionService;

	/*-----------------------METHODS-----------------------*/

	/**
	* Name:			index()
	* @Params:		
	* Description:	Retorna todas las entidades Position de BD
	* */
	@RequestMapping(value = ConstantsWS.WS_POSITIONS, method = RequestMethod.GET)
	public List<Position> index() {
		return positionService.findAll();
	}

	/**
	 * Name:		show()
	 * @Params:		id
	 * Description:	Retorna una posicion a partir de su id
	 * */
	@RequestMapping(value = ConstantsWS.WS_POSITION_ID, method = RequestMethod.GET)
	public Position show(@PathVariable(ConstantsWS.ID) Long id) {
		return positionService.findById(id);
	}

	/**
	 * Name:		create()
	 * @Params:		position
	 * Description:	Crea/Actualiza una entidad Position
	 * */
	@RequestMapping(value = ConstantsWS.WS_POSITION, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Position create(@RequestBody Position position) {

		Position positionToSave;
		Position positionExit;

		if (position.getId() != null) { // UPDATE
			positionToSave = positionService.findById(position.getId());

			if (position.getName() != null) {
				positionToSave.setName(position.getName());
			}

			if (position.getDescription() != null) {
				positionToSave.setDescription(position.getDescription());
			}
			if (position.getUsers() != null) {
				positionToSave.setUsers(position.getUsers());
			}

			positionExit = positionService.save(positionToSave);

		} else { // SAVE
			positionExit = positionService.save(position);
		}

		return positionExit;

	}

	/**
	 * Name:		delete()
	 * @Params:		id
	 * Description:	Elimina una entidad Position a partir de su id.
	 * */
	@RequestMapping(value = ConstantsWS.WS_POSITION_ID, method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(ConstantsWS.ID) Long id) {
		positionService.delete(id);
	}

}

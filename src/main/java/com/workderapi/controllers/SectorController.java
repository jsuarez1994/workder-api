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

import com.workderapi.entity.Sector;
import com.workderapi.services.SectorServiceIface;
import com.workderapi.util.Constants.ConstantsWS;

@CrossOrigin(origins = ConstantsWS.WS_DNS)
@RestController
@RequestMapping(ConstantsWS.WS_BASE_WORKDER_API)
public class SectorController {

	@Autowired
	SectorServiceIface sectorService;

	/*-----------------------METHODS-----------------------*/

	/**
	* Name:			index()
	* @Params:		
	* Description:	Retorna todas las entidades Sector de BD
	* */
	@RequestMapping(value = ConstantsWS.WS_SECTORS, method = RequestMethod.GET)
	public List<Sector> index() {
		return sectorService.findAll();
	}

	/**
	 * Name:		show()
	 * @Params:		id
	 * Description:	Retorna un sector a partir de su id
	 * */
	@RequestMapping(value = ConstantsWS.WS_SECTOR_ID, method = RequestMethod.GET)
	public Sector show(@PathVariable(ConstantsWS.ID) Long id) {
		return sectorService.findById(id);
	}

	/**
	 * Name:		create()
	 * @Params:		position
	 * Description:	Crea/Actualiza una entidad Sector
	 * */
	@RequestMapping(value = ConstantsWS.WS_SECTOR, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Sector create(@RequestBody Sector sector) {

		Sector sectorToSave;
		Sector sectorExit;

		if (sector.getId() != null) { // UPDATE
			sectorToSave = sectorService.findById(sector.getId());

			if (sector.getName() != null) {
				sectorToSave.setName(sector.getName());
			}

			if (sector.getDescription() != null) {
				sectorToSave.setDescription(sector.getDescription());
			}

			if (sector.getCompanys() != null) {
				sectorToSave.setCompanys(sector.getCompanys());
			}

			sectorExit = sectorService.save(sectorToSave);

		} else { // SAVE
			sectorExit = sectorService.save(sector);
		}

		return sectorExit;

	}

	/**
	 * Name:		delete()
	 * @Params:		id
	 * Description:	Elimina una entidad Sector a partir de su id.
	 * */
	@RequestMapping(value = ConstantsWS.WS_SECTOR_ID, method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(ConstantsWS.ID) Long id) {
		sectorService.delete(id);
	}

}

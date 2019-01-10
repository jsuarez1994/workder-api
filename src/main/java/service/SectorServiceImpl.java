package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.SectorDaoIface;
import entity.Sector;

@Service
public class SectorServiceImpl implements SectorServiceIface {

	@Autowired
	private SectorDaoIface sectorDao;

	/**
	 * Name:		finAll()
	 * Params:		None
	 * Description:	Return all Sector of data base
	 * */
	@Override
	public List<Sector> findAll() {
		return (List<Sector>)sectorDao.findAll();
	}

	/**
	* Name:			save(Sector Sector)
	* Params:		sector Bean Sector
	* Description:	Save the bean of params
	* */
	@Override
	public Sector save(Sector Sector) {
		return (Sector)sectorDao.save(Sector);
	}

	/**
	* Name:			delete(Long id)
	* Params:		id Type Long
	* Description:	Delete Sector by id
	* */
	@Override
	public void delete(Long id) {
		sectorDao.deleteById(id);
	}

	/**
	* Name:			findById(Long id)
	* Params:		id Type Long
	* Description:	Return Sector Bean by id or null if not exists.
	* */
	@Override
	public Sector findById(Long id) {
		return sectorDao.findById(id).orElse(null);
	}

}

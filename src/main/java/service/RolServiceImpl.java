package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.RolDaoIface;
import entity.Rol;

@Service
public class RolServiceImpl implements RolServiceIface {

	@Autowired
	private RolDaoIface rolDao;

	/**
	 * Name:		finAll()
	 * Params:		None
	 * Description:	Return all Rol of data base
	 * */
	@Override
	public List<Rol> findAll() {
		return (List<Rol>)rolDao.findAll();
	}

	/**
	* Name:			save(Rol Rol)
	* Params:		rol Bean Rol
	* Description:	Save the bean of params
	* */
	@Override
	public Rol save(Rol Rol) {
		return (Rol)rolDao.save(Rol);
	}

	/**
	* Name:			delete(Long id)
	* Params:		id Type Long
	* Description:	Delete Rol by id
	* */
	@Override
	public void delete(Long id) {
		rolDao.deleteById(id);
	}

	/**
	* Name:			findById(Long id)
	* Params:		id Type Long
	* Description:	Return Rol Bean by id or null if not exists.
	* */
	@Override
	public Rol findById(Long id) {
		return rolDao.findById(id).orElse(null);
	}

}

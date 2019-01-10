package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.PositionDaoIface;
import entity.Position;

public class PositionServiceImpl implements PositionServiceIface {

	@Autowired
	private PositionDaoIface positionDao;

	/**
	 * Name:		finAll()
	 * Params:		None
	 * Description:	Return all Position of data base
	 * */
	@Override
	public List<Position> findAll() {
		return (List<Position>)positionDao.findAll();
	}

	/**
	* Name:			save(Position Position)
	* Params:		position Bean Position
	* Description:	Save the bean of params
	* */
	@Override
	public Position save(Position position) {
		return (Position)positionDao.save(position);
	}

	/**
	* Name:			delete(Long id)
	* Params:		id Type Long
	* Description:	Delete Position by id
	* */
	@Override
	public void delete(Long id) {
		positionDao.deleteById(id);
	}

	/**
	* Name:			findById(Long id)
	* Params:		id Type Long
	* Description:	Return Position Bean by id or null if not exists.
	* */
	@Override
	public Position findById(Long id) {
		return positionDao.findById(id).orElse(null);
	}

}

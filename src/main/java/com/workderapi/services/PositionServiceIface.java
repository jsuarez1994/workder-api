package com.workderapi.services;

import java.util.List;

import com.workderapi.entity.Position;

public interface PositionServiceIface {
	
	public List<Position> findAll();

	public Position save(Position Position);

	public void delete(Long id);

	public Position findById(Long id);

}

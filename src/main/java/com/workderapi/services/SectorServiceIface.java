package com.workderapi.services;

import java.util.List;

import com.workderapi.entity.Sector;

public interface SectorServiceIface {
	
	public List<Sector> findAll();

	public Sector save(Sector Sector);

	public void delete(Long id);

	public Sector findById(Long id);

}

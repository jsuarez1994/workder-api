package com.workderapi.services;

import java.util.List;

import com.workderapi.entity.Rol;

public interface RolServiceIface {
	
	public List<Rol> findAll();

	public Rol save(Rol rol);

	public void delete(Long id);

	public Rol findById(Long id);

}

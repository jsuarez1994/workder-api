package service;

import java.util.List;
import entity.Rol;

public interface RolServiceIface {
	
	public List<Rol> findAll();

	public Rol save(Rol rol);

	public void delete(Long id);

	public Rol findById(Long id);

}

package service;

import java.util.List;
import entity.Company;

public interface CompanyServiceIface {
	
	public List<Company> findAll();

	public Company save(Company Company);

	public void delete(Long id);

	public Company findById(Long id);

}

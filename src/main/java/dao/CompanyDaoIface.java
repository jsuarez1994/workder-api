package dao;

import org.springframework.data.repository.CrudRepository;
import entity.Company;

public interface CompanyDaoIface extends CrudRepository<Company, Long> {

}

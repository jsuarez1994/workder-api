package com.workderapi.daos;

import org.springframework.data.repository.CrudRepository;

import com.workderapi.entity.Company;

public interface CompanyDaoIface extends CrudRepository<Company, Long> {

}

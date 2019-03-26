package com.workderapi.daos;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.workderapi.entity.Company;
import com.workderapi.entity.Order;
import com.workderapi.entity.User;

public interface UserDaoIface extends CrudRepository<User, Long> {
	
	User findByEmailAndPassword(String email, String password);
	
	List<User> findByCompany(Company idCompany);
	
	User findByOrders(Order order);
	
}

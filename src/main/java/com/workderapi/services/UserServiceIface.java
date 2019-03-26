package com.workderapi.services;

import java.util.List;

import com.workderapi.entity.Order;
import com.workderapi.entity.User;

public interface UserServiceIface {
	
	public List<User> findAll();

	public User save(User User);

	public void delete(Long id);

	public User findById(Long id);
	
	public User login(String email, String password);
	
	public List<User> findByCompany(Long idCompany);
	
	public User findByOrder(Order order);

}

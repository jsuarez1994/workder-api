package com.workderapi.services;

import java.util.List;
import com.workderapi.entity.Company;
import com.workderapi.entity.Order;
import com.workderapi.entity.User;

public interface OrderServiceIface {
	
	public List<Order> findAll();

	public Order save(Order order);

	public void delete(Long id);

	public Order findById(Long id);
	
	public List<Order> getOrdersCompleteByUser(User user);
	
	public List<Order> getOrdersIncompleteByUser(User user);
	
	public List<Order> getOrdersByUser(User user);

}

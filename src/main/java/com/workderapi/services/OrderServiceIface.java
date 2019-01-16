package com.workderapi.services;

import java.util.List;

import com.workderapi.entity.Order;

public interface OrderServiceIface {
	
	public List<Order> findAll();

	public Order save(Order order);

	public void delete(Long id);

	public Order findById(Long id);

}

package com.workderapi.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.workderapi.entity.Order;
import com.workderapi.entity.User;

public interface OrderDaoIface extends CrudRepository<Order, Long> {
	
	List<Order> findByUserAndCompleteTrue(User user);
	
	List<Order> findByUserAndCompleteFalse(User user);
	
}
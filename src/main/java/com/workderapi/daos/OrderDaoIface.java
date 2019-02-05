package com.workderapi.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.workderapi.entity.Order;

public interface OrderDaoIface extends CrudRepository<Order, Long> {
	
//	@Query("from Order order join fetch order.user us where us.id = ?1 and order.complete = true")
//	List<Order> getOrdersComplete(Long idUser);
//	
//	@Query("from Order order join fetch order.user us where us.id = ?1 and order.complete = false")
//	List<Order> getOrdersIncomplete(Long idUser);
	
}
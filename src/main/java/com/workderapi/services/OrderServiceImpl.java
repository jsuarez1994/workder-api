package com.workderapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workderapi.daos.OrderDaoIface;
import com.workderapi.daos.UserDaoIface;
import com.workderapi.entity.Order;
import com.workderapi.entity.User;

@Service
public class OrderServiceImpl implements OrderServiceIface {

	@Autowired
	private OrderDaoIface orderDao;
	
	@Autowired
	private UserDaoIface userDao;

	/**
	 * Name:		finAll()
	 * Params:		None
	 * Description:	Return all Order of data base
	 * */
	@Override
	public List<Order> findAll() {
		return (List<Order>)orderDao.findAll();
	}
	
	/**
	* Name:			findById(Long id)
	* Params:		id Type Long
	* Description:	Return Order Bean by id or null if not exists.
	* */
	@Override
	public Order findById(Long id) {
		return orderDao.findById(id).orElse(null);
	}
	
	/**
	 * Name:		getOrdersComplete()
	 * Params:		Long idUser
	 * Description:	Return all order of one user completed
	 * */
	@Override
	public List<Order> getOrdersComplete(Long id) {
		return orderDao.getOrdersComplete(id);
	}

	/**
	 * Name:		getOrdersIncomplete()
	 * Params:		Long idUser
	 * Description:	Return all order of one user completed
	 * */
	@Override
	public List<Order> getOrdersIncomplete(Long id) {
		return orderDao.getOrdersIncomplete(id);
	}
	
	/**
	* Name:			save(Order Order)
	* Params:		order Bean Order
	* Description:	Save the bean of params
	* */
	@Override
	public Order save(Order Order) {
		return (Order)orderDao.save(Order);
	}

	/**
	* Name:			delete(Long id)
	* Params:		id Type Long
	* Description:	Delete Order by id
	* */
	@Override
	public void delete(Long id) {
		orderDao.deleteById(id);
	}

	

}

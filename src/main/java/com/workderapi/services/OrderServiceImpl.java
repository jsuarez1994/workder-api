package com.workderapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workderapi.daos.OrderDaoIface;
import com.workderapi.daos.UserDaoIface;
import com.workderapi.entity.Company;
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
	public List<Order> getOrdersCompleteByUser(User user) {
		return orderDao.findByUserAndCompleteTrue(user);
	}

	/**
	 * Name:		getOrdersIncomplete()
	 * Params:		Long idUser
	 * Description:	Return all order of one user completed
	 * */
	@Override
	public List<Order> getOrdersIncompleteByUser(User user) {
		return orderDao.findByUserAndCompleteFalse(user);
	}
	
	/**
	 * Name:		getOrdersByUser()
	 * Params:		Long idUser
	 * Description:	Return all order of one user completed
	 * */
	@Override
	public List<Order> getOrdersByUser(User user) {
		return orderDao.findByUser(user);
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

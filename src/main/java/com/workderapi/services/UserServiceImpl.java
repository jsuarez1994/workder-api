package com.workderapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workderapi.daos.UserDaoIface;
import com.workderapi.entity.Company;
import com.workderapi.entity.Order;
import com.workderapi.entity.User;

@Service
public class UserServiceImpl implements UserServiceIface {
	
	@Autowired
	private UserDaoIface userDao;

	/**
	 * Name:		finAll()
	 * Params:		None
	 * Description:	Return all user of data base
	 * */
	@Override
	public List<User> findAll() {
		return (List<User>)userDao.findAll();
	}

	/**
	* Name:			save(User user)
	* Params:		user Bean User
	* Description:	Save the bean of params
	* */
	@Override
	public User save(User user) {
		return (User)userDao.save(user);
	}

	/**
	* Name:			delete(Long id)
	* Params:		id Type Long
	* Description:	Delete user by id
	* */
	@Override
	public void delete(Long id) {
		userDao.deleteById(id);
	}

	/**
	* Name:			findById(Long id)
	* Params:		id Type Long
	* Description:	Return User Bean by id or null if not exists.
	* */
	@Override
	public User findById(Long id) {
		return userDao.findById(id).orElse(null);
	}
	
	/**
	* Name:			findById(Long id)
	* Params:		id Type Long
	* Description:	Return User Bean by id or null if not exists.
	* */
	@Override
	public User login(String email, String password) {
		return userDao.findByEmailAndPassword(email, password);
	}
	
	/**
	* Name:			findByCompany(Long idCompany)
	* Params:		idCompany Type Long
	* Description:	Return List User Bean by id .
	* */
	@Override
	public List<User> findByCompanyAndUserActivatedTrue(Long idCompany) {
		Company company = new Company();
		company.setId(idCompany);
		return userDao.findByCompanyAndActivatedTrue(company);
	}
	
	/**
	* Name:			findByOrder(Order order)
	* Params:		Order order
	* Description:	Return User Bean by Order.
	* */
	@Override
	public User findByOrder(Order order) {
		return userDao.findByOrders(order);
	}


}

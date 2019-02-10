	package com.workderapi.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workderapi.entity.Company;
import com.workderapi.entity.Order;
import com.workderapi.entity.User;
import com.workderapi.services.CompanyServiceIface;
import com.workderapi.services.OrderServiceIface;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/workder_api")
public class OrderController {
	
	@Autowired
	OrderServiceIface orderService;	
	
	@Autowired
	CompanyServiceIface companyService;	
	
	/*-----------------------METHODS-----------------------*/
	
	/*-----------------------GETS--------------------------*/
	
	/**
	 * Name:		index()
	 * Params:		None
	 * Description:	Return all orders of database
	 * */
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public List<Order> index(){
		return orderService.findAll();
	}
	
	/**
	 * Name:		show()
	 * Params:		Long id
	 * Description:	Return order of id of params
	 * */
	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	public Order show(@PathVariable("id") Long id) {
		return orderService.findById(id);
	}
	
	/**
	 * Name:		getOrdersComplete()
	 * Params:		User user
	 * Description:	Return all order of one user completed
	 * */
	@RequestMapping(value = "/orders/complete", method = RequestMethod.POST)
	public List<Order> getOrdersComplete( @RequestBody User user ) {
		return orderService.getOrdersCompleteByUser(user);	
	}
	
	/**
	 * Name:		getOrdersIncomplete()
	 * Params:		User user
	 * Description:	Return all order of one user incompleted
	 * */
	@RequestMapping(value = "/orders/incomplete", method = RequestMethod.POST)
	public List<Order> getOrdersIncomplete( @RequestBody User user ) {
		return orderService.getOrdersIncompleteByUser(user);
	}
	
	/**
	 * Name:		getOrdersCompleteOfCompany()
	 * Params:		User user
	 * Description:	Return all order of one company completed
	 * */
	@RequestMapping(value = "/orders/company_complete", method = RequestMethod.POST)
	public List<Order> getOrdersCompleteByCompany( @RequestBody Company company ) {
		
		List<Order> ordersComplete = new ArrayList<>();
		
		Company companyUser = companyService.findById(company.getId());
		List<User> users = companyUser.getListUsers();
		
		
		for(User user : users) {
			ordersComplete.addAll(orderService.getOrdersCompleteByUser(user));
		}
		
		return ordersComplete;
	}
	
	/**
	 * Name:		getOrdersIncompleteOfCompany()
	 * Params:		User user
	 * Description:	Return all order of one company completed
	 * */
	@RequestMapping(value = "/orders/company_incomplete", method = RequestMethod.POST)
	public List<Order> getOrdersIncompleteByCompany( @RequestBody Company company ) {
		
		List<Order> ordersComplete = new ArrayList<>();
		
		Company companyUser = companyService.findById(company.getId());
		List<User> users = companyUser.getListUsers();
		
		
		for(User user : users) {
			ordersComplete.addAll(orderService.getOrdersIncompleteByUser(user));
		}
		
		return ordersComplete;
	}
	
	/**
	 * Name:		create/update()
	 * Params:		Order order
	 * Description:	Save or Update order send.
	 * */
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Order create(@RequestBody Order order) {
		
		Order orderToSave;
		Order orderExit;
		
		if( order.getId() != null ) { //UPDATE
			orderToSave = orderService.findById(order.getId());
			
			if(order.getDateInit() != null) {				
				orderToSave.setDateInit(order.getDateInit());
			}
			if(order.getDateFinish() != null) {				
				orderToSave.setDateFinish(order.getDateFinish());
			}
			if(order.getTitle() != null) {
				orderToSave.setTitle(order.getTitle());
			}
			if(order.getDescription() != null) {
				orderToSave.setDescription(order.getDescription());
			}
			if(order.getUser() != null) {
				orderToSave.setUser(order.getUser());
			}
			orderToSave.setUpdateAt(new Date());
			orderExit = orderService.save(orderToSave);
			
		} else { //SAVE			
			order.setCreateAt(new Date());
			order.setComplete(false);
			orderExit = orderService.save(order);
		}
		
		return orderExit;
		
	}
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		orderService.delete(id);
	}

}

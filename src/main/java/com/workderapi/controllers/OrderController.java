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
import com.workderapi.util.Constants.ConstantsWS;

@CrossOrigin(origins= ConstantsWS.WS_DNS)
@RestController
@RequestMapping(ConstantsWS.WS_BASE_WORKDER_API)
public class OrderController {
	
	@Autowired
	OrderServiceIface orderService;	
	
	@Autowired
	CompanyServiceIface companyService;	
	
	/*-----------------------METHODS-----------------------*/
	
	/**
	 * Name: index()
	 * @Params:  
	 * Description: Retorna todas las ordenes de BD
	 */
	@RequestMapping(value = ConstantsWS.WS_ORDERS, method = RequestMethod.GET)
	public List<Order> index(){
		return orderService.findAll();
	}
	
	/**
	 * Name:		show()
	 * @Params:		id
	 * Description:	Retorna una orden a partir de su id
	 * */
	@RequestMapping(value = ConstantsWS.WS_ORDER_ID, method = RequestMethod.GET)
	public Order show(@PathVariable(ConstantsWS.ID) Long id) {
		return orderService.findById(id);
	}
	
	/**
	 * Name:		getOrdersComplete()
	 * @Params:		user
	 * Description:	Retorna todas las ordenes completadas a partir de un usuario
	 * */
	@RequestMapping(value = ConstantsWS.WS_ORDERS_COMPLETE, method = RequestMethod.POST)
	public List<Order> getOrdersComplete( @RequestBody User user ) {
		return orderService.getOrdersCompleteByUser(user);	
	}
	
	/**
	 * Name:		getOrdersIncomplete()
	 * @Params:		user
	 * Description:	Retorna todas las ordenes incompletas a partir de un usuario
	 * */
	@RequestMapping(value = ConstantsWS.WS_ORDERS_INCOMPLETE, method = RequestMethod.POST)
	public List<Order> getOrdersIncomplete( @RequestBody User user ) {
		return orderService.getOrdersIncompleteByUser(user);
	}
	
	/**
	 * Name:		getOrdersByUser()
	 * @Params:		user
	 * Description:	Retorna todas las ordenes de un usuario
	 * */
	@RequestMapping(value = ConstantsWS.WS_ORDERS_USER, method = RequestMethod.POST)
	public List<Order> getOrdersByUser( @RequestBody User user ) {
		return orderService.getOrdersByUser(user);
	}
	
	/**
	 * Name:		getOrdersCompleteOfCompany()
	 * @Params:		user
	 * Description:	Retorna todas las ordenes completadas de una company
	 * */
	@RequestMapping(value = ConstantsWS.WS_ORDERS_COMPANY_COMPLETE, method = RequestMethod.POST)
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
	 * @Params:		user
	 * Description:	Retorna todas las ordenes incompletas de una company
	 * */
	@RequestMapping(value = ConstantsWS.WS_ORDERS_COMPANY_INCOMPLETE, method = RequestMethod.POST)
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
	 * Name:		create()
	 * @Params:		order
	 * Description:	Crea/Actualiza una entidad Order
	 * */
	@RequestMapping(value = ConstantsWS.WS_ORDER, method = RequestMethod.POST)
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
			if(order.getComplete() != null) {
				orderToSave.setComplete(order.getComplete());
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
	
	/**
	 * Name:		delete()
	 * @Params:		id
	 * Description:	Elimina una entidad Order a partir de su id.
	 * */
	@RequestMapping(value = ConstantsWS.WS_ORDER_ID, method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(ConstantsWS.ID) Long id) {
		orderService.delete(id);
	}

}

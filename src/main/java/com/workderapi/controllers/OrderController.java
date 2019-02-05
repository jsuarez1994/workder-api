package com.workderapi.controllers;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workderapi.entity.Order;
import com.workderapi.services.OrderServiceIface;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/workder_api")
public class OrderController {
	
	@Autowired
	OrderServiceIface orderService;	
	
	/*-----------------------METHODS-----------------------*/
	
	/*-----------------------GETS--------------------------*/
	
	/**
	 * Name:		index()
	 * Params:		None
	 * Description:	Return all orders of database
	 * */
	@GetMapping("/orders")
	public List<Order> index(){
		return orderService.findAll();
	}
	
	/**
	 * Name:		show()
	 * Params:		Long id
	 * Description:	Return order of id of params
	 * */
	@GetMapping("/orders/{id}")
	public Order show(@PathVariable("id") Long id) {
		return orderService.findById(id);
	}
	
	/**
	 * Name:		getOrdersComplete()
	 * Params:		Long idUser
	 * Description:	Return all order of one user completed
	 * */
//	@GetMapping("/orders/complete/{idUser}")
//	public List<Order> getOrdersComplete(@PathVariable("idUser") Long idUser ) {
//		return orderService.getOrdersComplete(idUser);
//	}
	
	/**
	 * Name:		getOrdersIncomplete()
	 * Params:		Long idUser
	 * Description:	Return all order of one user incompleted
	 * */
//	@GetMapping("/orders/incomplete/{idUser}")
//	public List<Order> getOrdersIncomplete(@PathVariable("idUser") Long idUser ) {
//		return orderService.getOrdersComplete(idUser);
//	}
	
	
	/*-----------------------CREATE/UPDATE--------------------------*/
	@PostMapping("/orders")
	@ResponseStatus(HttpStatus.CREATED)
	public Order create(@RequestBody Order order) {
		order.setCreateAt(new Date());
		order.setComplete(false);
		return orderService.save(order);
	}
	
	@PutMapping("/orders/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Order update (@RequestBody Order order, @PathVariable("id") Long id) {
		Order r = orderService.findById(id);

		r.setUpdateAt(new Date());
		r.setTitle(order.getTitle());
		r.setDescription(order.getDescription());
		r.setDateInit(order.getDateInit());
		r.setDateFinish(order.getDateFinish());
		r.setUser(order.getUser());
		
		return orderService.save(r);
	}
	
	
	
	/*-----------------------DELETE--------------------------*/
	@DeleteMapping("/orders/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		orderService.delete(id);
	}

}

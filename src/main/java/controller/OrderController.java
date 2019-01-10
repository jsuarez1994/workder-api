package controller;

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

import entity.Order;
import service.OrderServiceIface;
import util.Constants;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/workder_api")
public class OrderController {
	
	@Autowired
	private OrderServiceIface orderService;
	
	@Autowired
	private Constants constants;
	
	
	/*-----------------------METHODS-----------------------*/
	
	@GetMapping("/orders")
	public List<Order> index(){
		return orderService.findAll();
	}
	
	@GetMapping("/orders/{id}")
	public Order show(@PathVariable Long id) {
		return orderService.findById(id);
	}
	
	@PostMapping("/orders")
	@ResponseStatus(HttpStatus.CREATED)
	public Order create(@RequestBody Order order) {
		return orderService.save(order);
	}
	
	@PutMapping("/orders/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Order update (@RequestBody Order order, @PathVariable Long id) {
		Order r = orderService.findById(id);

		r.setUpdateAt(new Date());
		r.setTitle(order.getTitle());
		r.setDescription(order.getDescription());
		r.setDateInit(order.getDateInit());
		r.setDateFinish(order.getDateFinish());
		r.setUser(order.getUser());
		
		return orderService.save(r);
	}
	
	@DeleteMapping("/orders/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		orderService.delete(id);
	}

}

package service;

import java.util.List;
import entity.Order;

public interface OrderServiceIface {
	
	public List<Order> findAll();

	public Order save(Order order);

	public void delete(Long id);

	public Order findById(Long id);

}

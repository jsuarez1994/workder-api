package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.OrderDaoIface;
import entity.Order;

@Service
public class OrderServiceImpl implements OrderServiceIface {

	@Autowired
	private OrderDaoIface orderDao;

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

	/**
	* Name:			findById(Long id)
	* Params:		id Type Long
	* Description:	Return Order Bean by id or null if not exists.
	* */
	@Override
	public Order findById(Long id) {
		return orderDao.findById(id).orElse(null);
	}

}

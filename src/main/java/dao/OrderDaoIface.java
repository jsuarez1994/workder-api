package dao;

import org.springframework.data.repository.CrudRepository;
import entity.Order;

public interface OrderDaoIface extends CrudRepository<Order, Long> {

}

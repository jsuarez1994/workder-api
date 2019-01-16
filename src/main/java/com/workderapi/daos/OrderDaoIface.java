package com.workderapi.daos;

import org.springframework.data.repository.CrudRepository;

import com.workderapi.entity.Order;

public interface OrderDaoIface extends CrudRepository<Order, Long> {

}

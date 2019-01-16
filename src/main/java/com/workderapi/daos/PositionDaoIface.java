package com.workderapi.daos;

import org.springframework.data.repository.CrudRepository;

import com.workderapi.entity.Position;

public interface PositionDaoIface extends CrudRepository<Position, Long> {

}

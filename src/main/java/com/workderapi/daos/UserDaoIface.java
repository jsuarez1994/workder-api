package com.workderapi.daos;
import org.springframework.data.repository.CrudRepository;

import com.workderapi.entity.User;

public interface UserDaoIface extends CrudRepository<User, Long> {}

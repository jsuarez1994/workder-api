package service;

import java.util.List;
import entity.User;

public interface UserServiceIface {
	
	public List<User> findAll();

	public User save(User User);

	public void delete(Long id);

	public User findById(Long id);

}

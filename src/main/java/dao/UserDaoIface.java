package dao;
import org.springframework.data.repository.CrudRepository;
import entity.User;

public interface UserDaoIface extends CrudRepository<User, Long> {}

package dao;

import org.springframework.data.repository.CrudRepository;
import entity.Position;

public interface PositionDaoIface extends CrudRepository<Position, Long> {

}

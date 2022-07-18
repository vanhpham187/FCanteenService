package fcantenn.repository;

import fcantenn.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenuRepository extends JpaRepository<Dish, Integer>{
    List<Dish> findAll();
}

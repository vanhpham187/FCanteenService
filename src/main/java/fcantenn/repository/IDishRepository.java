package fcantenn.repository;

import fcantenn.model.Dish;
import fcantenn.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDishRepository extends JpaRepository<Dish, Integer> {
    List<Dish> findAllByStore(Store store);
}

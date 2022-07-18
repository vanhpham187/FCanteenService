package fcantenn.repository;

import fcantenn.model.Dish;
import fcantenn.model.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMenuRepository extends JpaRepository<Dish, Integer>{
    List<Dish> findAll();

    Optional<Dish> findById(Integer integer);

    List<Dish> findByStore(Store store);



}

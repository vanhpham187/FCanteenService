package fcantenn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fcantenn.model.Store;

@Repository
public interface IStoreRepository extends JpaRepository<Store, Integer>{
    List<Store> findAll();
}

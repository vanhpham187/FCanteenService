package fcantenn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fcantenn.model.Kiosk;

@Repository
public interface IKioskRepository extends JpaRepository<Kiosk, Integer>{

}

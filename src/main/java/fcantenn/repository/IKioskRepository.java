package fcantenn.repository;

import fcantenn.model.Kiosk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IKioskRepository extends JpaRepository<Kiosk, Integer> {
    List<Kiosk> findAll();

    Kiosk save(Kiosk kiosk);

    Optional<Kiosk> findById(Integer integer);
    //    Kiosk findKioskByKiosk_id(Integer integer);
}

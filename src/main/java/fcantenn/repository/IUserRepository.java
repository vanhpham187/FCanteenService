package fcantenn.repository;

import fcantenn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String email);

    List<User> findAll();
    User getUserById(Integer integer);

    User save(User user);

    void deleteById(Integer integer);
}

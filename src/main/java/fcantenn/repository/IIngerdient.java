package fcantenn.repository;

import fcantenn.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIngerdient extends JpaRepository<Ingredient, Long> {
}

package fcantenn.service;

import fcantenn.model.Dish;
import fcantenn.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IDishService  {
    List<Dish> getDishByStore(User user);

}
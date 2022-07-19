package fcantenn.service.implement;

import fcantenn.model.Dish;
import fcantenn.model.User;
import fcantenn.repository.IDishRepository;
import fcantenn.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DishServiceImpl implements IDishService {
    @Autowired
    private IDishRepository dishRepository;

    @Override
    public List<Dish> getDishByStore(User user) {

        List<Dish> dishList = dishRepository.findAllByStore(user.getStore());
        return dishList;
    }
}

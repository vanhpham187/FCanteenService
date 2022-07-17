package fcantenn.controller;

import fcantenn.model.Order;
import fcantenn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class StaffController {
    @Qualifier("userServiceImpl")
    @Autowired
    private IUserService userService;

    public Order displayOrder(Order order) {
        return order;
    }

}

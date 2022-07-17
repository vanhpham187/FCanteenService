package fcantenn.controller;

import fcantenn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ManagerController {
    @Qualifier("userServiceImpl")
    @Autowired
    private IUserService userService;
    
}

package fcantenn.controller;

import fcantenn.model.Dish;
import fcantenn.model.User;
import fcantenn.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DishController {
    @Qualifier("dishServiceImpl")
    @Autowired
    private IDishService dishService;
    @Autowired
    HttpSession session;

    @RequestMapping("/menu")
    public String dishMenu(Model model, HttpServletRequest request) {
        User user = (User) session.getAttribute("userInformation");
        List<Dish> dishList = dishService.getDishByStore(user);
        model.addAttribute("dishList", dishList);
        return "dishMenu";
    }
}

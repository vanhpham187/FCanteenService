package fcantenn.controller;

import fcantenn.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping(value = "/userHome")
    public String ShowHomePage1(){
        return "home-page1";
    }
    @GetMapping(value = "/adminHome")
    public String ShowHomePage2(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "adminPage";
    }
    @GetMapping(value = "/staffHome")
    public String ShowStaffHomePage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "staffPage";
    }
}

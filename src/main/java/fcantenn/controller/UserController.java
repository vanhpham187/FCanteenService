package fcantenn.controller;

import fcantenn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    HttpSession session;

    @GetMapping("/user-profile")
    public String UserProfile(Model model) {
        User user = (User) session.getAttribute("userInformation");
        model.addAttribute("userinfo", user);
        return "user-profile";
    }
}

package fcantenn.controller;

import fcantenn.model.User;
import fcantenn.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    HttpSession session;
    @Autowired
    private IUserRepository userRepository;
    @GetMapping("/user-profile")
    public String UserProfile(Model model) {
        User user = (User) session.getAttribute("userInformation");
        model.addAttribute("userinfo", user);
        return "user-profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(HttpServletRequest request) {
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        User user = (User) session.getAttribute("userInformation");
        user.setLast_name(lName);
        user.setFirst_name(fName);
        user.setPhone(phone);
        user.setEmail(email);
        user.setAddress(address);
        userRepository.save(user);
        session.setAttribute("userInformation", user);
        return "redirect:/user-profile";
    }
}

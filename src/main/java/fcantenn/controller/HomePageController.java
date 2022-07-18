package fcantenn.controller;

import fcantenn.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        return "redirect:/admin/ManageAccount";
    }
    @GetMapping(value = "/staffHome")
    public String ShowStaffHomePage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "staffPage";
    }
    @GetMapping(value = "/managerHome")
    public String ShowManagerHomePage(){
        return "managerHomePage";
    }

    @GetMapping(value = "/home")
    public ModelAndView ShowHome(HttpServletRequest request){
        HttpSession session=request.getSession();
        String role= (String) session.getAttribute("role");
        switch(role){
            case "ADMIN":
                return new ModelAndView("redirect:/admin/ManageAccount");
            case "STUDENT":
                return new ModelAndView("redirect:/userHome");
            case "MANAGER":
                return new ModelAndView("redirect:/managerHome");
            case "STAFF":
                return new ModelAndView("redirect:/staffHome");
            default:
                return new ModelAndView("redirect:/login");
        }
    }
}

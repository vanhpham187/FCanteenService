package fcantenn.controller;

import fcantenn.exception.UserAlreadyExistException;
import fcantenn.model.User;
import fcantenn.repository.IUserRepository;
import fcantenn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {
    @Qualifier("userServiceImpl")
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserRepository userRepository;
    @PostMapping(value = "/signupStaff")
    public ModelAndView signupStaff(HttpServletRequest request, @ModelAttribute("user") User user, @ModelAttribute("message") String message) throws UserAlreadyExistException, Exception{
        ModelAndView mav = new ModelAndView("adminPage");
        try{
            if (!user.getPassword().equals(request.getParameter("confirm-password"))){
                throw new Exception();
            }
            userService.registerNewUserAccountStaff(user);
            message = "Sign up for staff successfully!";
            mav.addObject("message", message);
            return mav;
        }catch (UserAlreadyExistException e){
            message = "An account for that username/email already exists.";
            mav.addObject("message", message);
            return mav;
        } catch (Exception e) {
            message = "Confirm password doesn't match with password";
            mav.addObject("message", message);
            return mav;
        }
    }
    @GetMapping(value = "/adminManageAccount")
    public String manageAccount(Model model){
        User user = new User();
        model.addAttribute("user", user);
        List<User> userList = userRepository.findAll();
        model.addAttribute("allUser",userList);
        return "admin_manageAccount";
    }
    @GetMapping(value = "/adminEditAccount")
    public String editAccount(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "admin_editAccount";
    }
    @GetMapping(value = "/adminDeleteAccount/{id}")
    public String deleteAccount(@PathVariable(required=false,name="id") String id, Model model){
        userRepository.deleteById(Integer.parseInt(id));
        return "redirect:/adminManageAccount";
    }
}

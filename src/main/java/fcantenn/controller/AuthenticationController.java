package fcantenn.controller;

import fcantenn.exception.UserAlreadyExistException;
import fcantenn.model.User;
import fcantenn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthenticationController {
    @Qualifier("userServiceImpl")
    @Autowired private IUserService userService;

    @GetMapping(value = "/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping(value = "/signup")
    public String signup(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "sign-up";
    }

    @PostMapping(value = "/signup")
    public ModelAndView signup(HttpServletRequest request,@ModelAttribute("user") User user) throws UserAlreadyExistException, Exception{
        ModelAndView mav = new ModelAndView("signup");
        try{
            if (!user.getPassword().equals(request.getParameter("confirm-password"))){
                throw new Exception();
            }
            userService.registerNewUserAccount(user);
        }catch (UserAlreadyExistException e){
            mav.addObject("message", "An account for that username/email already exists.");
            return mav;
        } catch (Exception e) {
            mav.addObject("message", "Confirm password doesn't match with password");
            return mav;
        }
        return new ModelAndView("login", "user", user);
    }
}

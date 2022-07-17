package fcantenn.controller;

import fcantenn.exception.UserAlreadyExistException;
import fcantenn.model.User;
import fcantenn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Qualifier("userServiceImpl")
    @Autowired
    private IUserService userService;

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
}

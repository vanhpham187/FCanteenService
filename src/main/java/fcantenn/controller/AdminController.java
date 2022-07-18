package fcantenn.controller;

import fcantenn.exception.UserAlreadyExistException;
import fcantenn.model.Kiosk;
import fcantenn.model.User;
import fcantenn.repository.IKioskRepository;
import fcantenn.repository.IUserRepository;
import fcantenn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Qualifier("userServiceImpl")
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IKioskRepository kioskRepository;
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
    @GetMapping(value = "/admin/ManageAccount")
    public String manageAccount(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        if(session.getAttribute("role")==null) return "redirect:/login";
        String role = (String)session.getAttribute("role") ;
        if (role !="ADMIN") return "redirect:/home";
        User user = new User();
        model.addAttribute("user", user);
        List<User> userList = userRepository.findAll();
        model.addAttribute("allUser",userList);
        return "admin_manageAccount";
    }
    @GetMapping(value = "/admin/EditAccount/{id}")
    public String editAccount(HttpServletRequest request,@PathVariable(required=true,name="id") String id,Model model){
        HttpSession session = request.getSession();
        if(session.getAttribute("role")==null) return "redirect:/login";
        String role = (String)session.getAttribute("role") ;
        if (role !="ADMIN") return "redirect:/home";
        User user = new User();
        model.addAttribute("user", user);
        User editUser=userRepository.getUserById(Integer.parseInt(id));
        model.addAttribute("editUser",editUser);
        return "admin_editAccount";
    }
    @PostMapping(value = "/admin/EditAccount")
    public ModelAndView editAccount(HttpServletRequest request,@ModelAttribute("editUser") User user) throws Exception{
        HttpSession session = request.getSession();
        if(session.getAttribute("role")==null) return new ModelAndView("redirect:/login");
        String role = (String)session.getAttribute("role") ;
        if (role !="ADMIN") return new ModelAndView( "redirect:/home");
        ModelAndView mav = new ModelAndView("admin_editAccount");
        User updateU=userRepository.getUserById(user.getId());
        updateU.setFirst_name(user.getFirst_name());
        updateU.setLast_name(user.getLast_name());
        updateU.setEmail(user.getEmail());
        updateU.setPhone(user.getPhone());
        updateU.setAddress(user.getAddress());
        userRepository.save(updateU);
        return new ModelAndView("redirect:/admin/ManageAccount");
    }
    @GetMapping(value = "/admin/DeleteAccount/{id}")
    public String deleteAccount(HttpServletRequest request,@PathVariable(required=true,name="id") String id, Model model){
        HttpSession session = request.getSession();
        if(session.getAttribute("role")==null) return "redirect:/login";
        String role = (String)session.getAttribute("role") ;
        if (role !="ADMIN") return "redirect:/home";
        userRepository.deleteById(Integer.parseInt(id));
        return "redirect:/admin/ManageAccount";
    }
    @GetMapping(value = "/admin/ManageKiosk")
    public String manageKiosk(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        if(session.getAttribute("role")==null) return "redirect:/login";
        String role = (String)session.getAttribute("role") ;
        if (role !="ADMIN") return "redirect:/home";
        User user = new User();
        model.addAttribute("user", user);
        List<Kiosk> kioskList = kioskRepository.findAll();
        model.addAttribute("allKiosk",kioskList);
        return "admin_manageKiosk";
    }
    @GetMapping(value = "/admin/EditKiosk/{id}")
    public String editKiosk(HttpServletRequest request,@PathVariable(required=true,name="id") String id,Model model){
        HttpSession session = request.getSession();
        if(session.getAttribute("role")==null) return "redirect:/login";
        String role = (String)session.getAttribute("role") ;
        if (role !="ADMIN") return "redirect:/home";
        User user = new User();
        model.addAttribute("user", user);
        Kiosk kiosk=kioskRepository.getById(Integer.parseInt(id));
        model.addAttribute("kiosk",kiosk);
        return "admin_editKiosk";
    }
    @PostMapping(value = "/admin/EditKiosk")
    public ModelAndView editKiosk(HttpServletRequest request,@ModelAttribute("kiosk") Kiosk kiosk) throws Exception{
        HttpSession session = request.getSession();
        if(session.getAttribute("role")==null) return new ModelAndView("redirect:/login");
        String role = (String)session.getAttribute("role") ;
        if (role !="ADMIN") return new ModelAndView( "redirect:/home");
        Kiosk kioskU=kioskRepository.getById(kiosk.getKiosk_id());
        kioskU.setLocation(kiosk.getLocation());
        kioskU.setOwner_name(kiosk.getOwner_name());
        kioskU.setOwner_phone(kiosk.getOwner_phone());
        kioskU.setRental_fee(kiosk.getRental_fee());
        kioskRepository.save(kioskU);
        return new ModelAndView("redirect:/admin/ManageKiosk");
    }
    @GetMapping(value = "/admin/DeleteKiosk/{id}")
    public String deleteKiosk(HttpServletRequest request,@PathVariable(required=true,name="id") String id, Model model){
        HttpSession session = request.getSession();
        if(session.getAttribute("role")==null) return "redirect:/login";
        String role = (String)session.getAttribute("role") ;
        if (role !="ADMIN") return "redirect:/home";
        kioskRepository.deleteById(Integer.parseInt(id));
        return "redirect:/admin/ManageKiosk";
    }
    @GetMapping(value = "/admin/AddKiosk")
    public String addKiosk(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        if(session.getAttribute("role")==null) return "redirect:/login";
        String role = (String)session.getAttribute("role") ;
        if (role !="ADMIN") return "redirect:/login";
        User user = new User();
        model.addAttribute("user", user);
        Kiosk kiosk=new Kiosk();
        model.addAttribute("kiosk",kiosk);
        return "admin_addKiosk";
    }
    @PostMapping(value = "/admin/AddKiosk")
    public ModelAndView addKiosk(HttpServletRequest request,@ModelAttribute("kiosk") Kiosk kiosk) throws Exception{
        HttpSession session = request.getSession();
        if(session.getAttribute("role")==null) return new ModelAndView("redirect:/login");
        String role = (String)session.getAttribute("role") ;
        if (role !="ADMIN") return new ModelAndView( "redirect:/home");
        kioskRepository.save(kiosk);
        return new ModelAndView("redirect:/admin/ManageKiosk");
    }
}

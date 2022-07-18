package fcantenn.controller;

import fcantenn.model.Kiosk;
import fcantenn.model.Store;
import fcantenn.model.User;
import fcantenn.repository.IKioskRepository;
import fcantenn.repository.IStoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    HttpSession session;
    @Autowired
    private IStoreRepository storeRepository;

    @GetMapping("/user-profile")
    public String UserProfile(Model model) {
        User user = (User) session.getAttribute("userInformation");
        model.addAttribute("userinfo", user);
        return "user-profile";
    }

    @GetMapping(value = "/userHome/menu")
    public String manageStore(Model model){
        Store store = new Store();
        
        model.addAttribute("store", store);
        List<Store> storeList = storeRepository.findAll();
        model.addAttribute("allStore",storeList); 
        
        return "student_viewMenu";
    }
}

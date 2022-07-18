package fcantenn.controller;

import fcantenn.model.Dish;
import fcantenn.model.Store;
import fcantenn.model.User;
import fcantenn.repository.IMenuRepository;
import fcantenn.repository.IStoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    HttpSession session;
    @Autowired
    private IStoreRepository storeRepository;
    @Autowired
    private IMenuRepository menuRepository ;

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

    @GetMapping(value = "/userHome/menu/{id}")
    public String manageMenu(@PathVariable(required=true,name="id") String id,Model model){
        Dish dish = new Dish();
        Store store = storeRepository.getById(Integer.parseInt(id));
        
        model.addAttribute("dish", dish);
        List<Dish> menuList = menuRepository.findByStore(store);
        model.addAttribute("allDish", menuList); 
        
        return "student_viewDish";
    }
}

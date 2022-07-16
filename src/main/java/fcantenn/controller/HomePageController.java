package fcantenn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping(value = "/home1")
    public String ShowHomePage1(){
        return "home-page1";
    }
    @GetMapping(value = "/home2")
    public String ShowHomePage2(){
        return "home-page2";
    }
}

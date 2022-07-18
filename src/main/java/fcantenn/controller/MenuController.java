package fcantenn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

import fcantenn.repository.IMenuRepository;

public class MenuController {
    @Qualifier("userServiceImpl")
    @Autowired
    private IMenuRepository menuRepository;


}

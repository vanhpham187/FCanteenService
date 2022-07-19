package fcantenn.controller;

import fcantenn.model.Order;
import fcantenn.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderController {
    @Qualifier("orderServiceImpl")
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/order-list")
    public String displayOrder(Model model) {
        List<Order> orderList = orderService.getOrderList();
        model.addAttribute("orderList", orderList);
        return "orderMenu";
    }
}

package fcantenn.service.implement;

import fcantenn.model.Order;
import fcantenn.repository.IOrderRepository;
import fcantenn.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;


    @Override
    public List<Order> getOrderList() {
        List<Order> orderList = orderRepository.findAll();
        return orderList;
    }
}

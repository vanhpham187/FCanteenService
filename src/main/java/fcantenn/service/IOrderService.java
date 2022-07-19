package fcantenn.service;

import fcantenn.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService  {
    List<Order> getOrderList();

}
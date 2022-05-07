package ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.entity.Order;
import ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.repository.OrderRepository;


import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

      public Order getOrderById(int id) {
        Order order = null;
        Optional<Order> o = orderRepository.findById(id);
        if (o.isPresent()) {
            order = o.get();
        }
        return order;
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }


    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}

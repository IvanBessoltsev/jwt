package ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}

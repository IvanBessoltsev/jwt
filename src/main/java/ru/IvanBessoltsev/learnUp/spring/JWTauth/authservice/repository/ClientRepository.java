package ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.entity.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

//    public Client findClientByEmailEquals (String email);


}

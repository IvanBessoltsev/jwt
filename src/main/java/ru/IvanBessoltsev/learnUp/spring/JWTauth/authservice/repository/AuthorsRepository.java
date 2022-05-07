package ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.entity.Authors;


@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Integer> {
}

package ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.entity.Book;



import java.util.List;


@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

   public  List<Book> findAllByTitleContainsAndPriceEquals(String title, double price);
}

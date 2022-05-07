package ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.Service.BookService;
import ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.entity.Book;


import java.util.List;


@RestController
public class ResourceController {
    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public List<Book> auth() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Book> allBooks = this.bookService.getAllBooks();
        if (principal.equals("user")) {
            return allBooks;
        }
        return null ;
    }
}





package com.demo.springboot.hibernatejpademo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {
    @GetMapping("/books")
    List<Book> getAllBooks(){
        return Arrays.asList(
                new Book(4,"Spring Fundamental","Jack Dow")
        );
    }
}

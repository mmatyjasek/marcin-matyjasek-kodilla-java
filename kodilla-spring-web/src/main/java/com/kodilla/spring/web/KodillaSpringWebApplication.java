package com.kodilla.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KodillaSpringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodillaSpringWebApplication.class, args);
    }


    @GetMapping(value = "sum/{a}/{b}")
    public int sumValues(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    @GetMapping(value = "subtract")
    public int subtractValues(int a, int b) {
        return a - b;
    }

    @PostMapping(value = "book")
    public Book createBook(@RequestBody Book book) {
        book.id = -1;

        return book;
    }


}


class Book {
    int id;
    String title;
    double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


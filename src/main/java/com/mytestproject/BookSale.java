package com.mytestproject;

import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")

public class BookSale {
    List<Book> bookList = new ArrayList<>( );

    @GetMapping("")
    public String welcome() {
        return "Hey! My Book Sale application.";
    }

    @GetMapping("/all-books")
    public List<Book> getBooks() {
        return bookList ;

    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") int id ) {
        return bookList.get(id);
    }

    @PostMapping("/add-book")
    public void addBook(@RequestBody Book book) {
        bookList.add(book);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") int id ) {
        bookList.remove(id ) ;
    }

    @GetMapping("/update/{id}")
    public String update (@PathVariable("id") int id) {
        Book book = bookList.get(id) ;
        bookList.remove(id) ;

        return "redirect : /add-book";
    }
}

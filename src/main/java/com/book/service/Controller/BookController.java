package com.book.service.Controller;

import com.book.service.Repository.BookRepository;
import com.book.service.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository repo;

    @GetMapping
    public List<Book> getAll() { return repo.findAll(); }
    @PostMapping
    public Book create(@RequestBody Book book) { return repo.save(book); }
    @GetMapping("/{id}") public ResponseEntity<Book> getOne(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
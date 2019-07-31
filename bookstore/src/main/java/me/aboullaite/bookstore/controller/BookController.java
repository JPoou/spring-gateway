package me.aboullaite.bookstore.controller;

import me.aboullaite.bookstore.model.Book;
import me.aboullaite.bookstore.model.Demobook;
import me.aboullaite.bookstore.repository.DemobookRepository;
import me.aboullaite.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    DemobookRepository repositorio;

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping("demo")
    public ResponseEntity<List<Demobook>> getAllDemoBooks(){
        return ResponseEntity.ok((List)repositorio.findAll());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){
        Optional<Book> optBook = bookService.getBookByIsbn(isbn);
        if(optBook.isPresent())
            return ResponseEntity.ok(optBook.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Book());
    }

    @GetMapping("/danger")
    public ResponseEntity<List<Book>> unstableBooksEndpoint(){
        return ResponseEntity.ok(bookService.longExecutionMethod());
    }
}

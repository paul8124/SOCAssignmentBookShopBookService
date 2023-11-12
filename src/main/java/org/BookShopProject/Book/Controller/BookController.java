package org.BookShopProject.Book.Controller;


import jakarta.validation.Valid;

import org.BookShopProject.Book.Model.BookDetails;
import org.BookShopProject.Book.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    // Get All Books
    @GetMapping(value = "/getBooks")
    public ResponseEntity<List<BookDetails>> getBooks() throws Exception {
        List<BookDetails> registeredBooks = bookService.getBook();
        return new ResponseEntity<>(registeredBooks, HttpStatus.OK);
    }

    //Get Single Book By Id
    @GetMapping(value = "/getBook/{id}")
    public ResponseEntity<BookDetails> getBook(@PathVariable Long id) throws Exception {
        BookDetails registeredBook = bookService.getBookById(id);
        return new ResponseEntity<>(registeredBook, HttpStatus.OK);
    }

    // Add New Book
    @PostMapping(value = "/addBook")
    public ResponseEntity<String> addBook(@Valid @RequestBody BookDetails book) throws Exception {

        String registeredWithEmailID = bookService.addBook(book);
        return new ResponseEntity<>(registeredWithEmailID, HttpStatus.OK);
    }

    // Delete Book By Id
    @DeleteMapping(value = "/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) throws Exception {

        String registeredWithID = bookService.deleteBook(id);
        return new ResponseEntity<>(registeredWithID, HttpStatus.OK);
    }
    
}

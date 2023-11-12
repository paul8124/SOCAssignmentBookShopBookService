package org.BookShopProject.Book.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;

import org.BookShopProject.Book.Entity.BookDetailsEntity;
import org.BookShopProject.Book.Model.BookDetails;
import org.BookShopProject.Book.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public String addBook(BookDetails book) {
        BookDetailsEntity bookDetailsEntity = BookDetailsEntity.builder()
                .name(book.getName())
                .publisher(book.getPublisher())
                .price(book.getPrice())
                .availableQuantity(book.getAvailableQuantity()).build();
        try {
            bookRepository.save(bookDetailsEntity);
            return "Book Added Successfully";
        } catch (Exception e) {
            return "Book Addition Failed. Error: " + e.getMessage();
        }
    }

    @Override
    public List<BookDetails> getBook() {
        List<BookDetailsEntity> listBooks = bookRepository.findAll();
        List<BookDetails> listBookDetails = new ArrayList<>();
        for (BookDetailsEntity book: listBooks) {
            BookDetails bookDetails = new BookDetails();
            bookDetails.setBookId(book.getBookId());
            bookDetails.setName(book.getName());
            bookDetails.setPublisher(book.getPublisher());
            bookDetails.setPrice(book.getPrice());
            bookDetails.setAvailableQuantity(book.getAvailableQuantity());
            listBookDetails.add(bookDetails);
        }
        return listBookDetails;
    }

    @Override
    public BookDetails getBookById(Long id) throws Exception {
        Optional<BookDetailsEntity> singleBook = bookRepository.findById(id);
        BookDetails bookDetails = new BookDetails();
       if (singleBook.isPresent()) {
           bookDetails.setBookId(singleBook.get().getBookId());
           bookDetails.setName(singleBook.get().getName());
           bookDetails.setPublisher(singleBook.get().getPublisher());
           bookDetails.setPrice(singleBook.get().getPrice());
           bookDetails.setAvailableQuantity(singleBook.get().getAvailableQuantity());
       }
       else {
           bookDetails.setError("No Book Found!");
       }
        return bookDetails;
    }

    @Override
    public String deleteBook(Long id) throws Exception {
        try {
            bookRepository.deleteById(id);
            return "Book Id " + id + " Deleted Successfully!";
        } catch(Exception e) {
            return " Error in deleting book : " + e.getMessage();
        }
//        UserDetails user = getUserById(id);
//        if (user.getError().equalsIgnoreCase("No User Found!"))
//            return "No User Found!";
//        else {
//            userRepository.delete
//            return "User Id " + id + " Deleted Successfully!";
//        }
    }

}

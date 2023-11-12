package org.BookShopProject.Book.Service;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.BookShopProject.Book.Model.BookDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBookService {

    public String addBook(BookDetails book);

    public List<BookDetails> getBook();

    public BookDetails getBookById(Long id) throws Exception;

    public String deleteBook(Long id) throws Exception;

}

package org.BookShopProject.Book.Repository;



import org.BookShopProject.Book.Entity.BookDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookDetailsEntity, Long> {

}

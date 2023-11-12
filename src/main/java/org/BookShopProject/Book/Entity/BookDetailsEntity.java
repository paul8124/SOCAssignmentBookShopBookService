package org.BookShopProject.Book.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BookDetails")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailsEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column
    private String name;
    @Column
    private String publisher;
    @Column
    private Double price;
    @Column
    private Integer availableQuantity;

}

package org.BookShopProject.Book.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookDetails {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long bookId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String publisher;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer availableQuantity;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  String error;

}

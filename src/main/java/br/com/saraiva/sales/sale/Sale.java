package br.com.saraiva.sales.sale;

import br.com.saraiva.sales.book.Book;
import br.com.saraiva.sales.costumer.Costumer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "sales")
public class Sale implements Serializable {

    @Id
    private String id;

    private Book book;
    private Costumer costumer;

    private Long total;
}

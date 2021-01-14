package br.com.saraiva.sales.book;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.saraiva.sales.book.dto.ApiBookRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "books")
public class Book implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String specificId;
    private String tittle;
    private String author;
    private String year;
    private Long price;

    public static Book fromApiBookRequest(ApiBookRequest apiBookRequest){
        
        return Book.builder()
        .author(apiBookRequest.getAuthor())
        .specificId(apiBookRequest.getSpecificId())
        .tittle(apiBookRequest.getTittle())
        .year(apiBookRequest.getYear())
                .price(apiBookRequest.getPrice())
        .build();
    }
}

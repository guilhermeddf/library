package br.com.saraiva.sales.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ApiBookRequest {

    private String specificId;
    private String tittle;
    private String author;
    private String year;
    private Long price;
}

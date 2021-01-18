package br.com.saraiva.sales.book;

public class BookBuilder {

    public static Book createBook(){
        return Book.builder()
        .author("Guilherme Freitas")
        .tittle("O Best Seller do ano")
        .year("1991")
        .specificId("10010")
                .price(15L)
        .build();
    }
    
}

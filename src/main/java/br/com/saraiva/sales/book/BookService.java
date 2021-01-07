package br.com.saraiva.sales.book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

    Mono<Book> save(Book book);
    Flux<Book> list();
    Mono<Book> getBySpecificId(String specificId);
    Mono<Void> delete(String specificId);
    
}

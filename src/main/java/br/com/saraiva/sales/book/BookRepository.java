package br.com.saraiva.sales.book;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, Long>{

    Mono<Book> findBySpecificId(String specificId);
    Mono<Book> save(Book book);
	Mono<Void> deleteBySpecificId(String specificId);
	Mono<Boolean> existsBySpecificId(String specificId);
}

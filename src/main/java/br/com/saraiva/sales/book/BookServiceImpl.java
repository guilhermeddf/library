package br.com.saraiva.sales.book;

import br.com.saraiva.sales.exceptions.BookNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Mono<Book> save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Flux<Book> list() {
        return bookRepository.findAll();
    }

    @Override
    public Mono<Book> getBySpecificId(String specificId) {
        return bookRepository.findBySpecificId(specificId)
        .switchIfEmpty(Mono.error(new BookNotFoundException("message")));
    }

    @Override
    public Mono<Void> delete(String specificId){
        return bookRepository.deleteBySpecificId(specificId);
    }
}

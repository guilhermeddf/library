package br.com.saraiva.sales.book;

import br.com.saraiva.sales.exceptions.BookAlreadyExistsException;
import br.com.saraiva.sales.exceptions.BookNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Mono<Book> save(Book book) {
        return bookRepository.findBySpecificId(book.getSpecificId())
                .flatMap(b -> {
                    if(b.getSpecificId().equals(book.getSpecificId())) {
                        return Mono.error(new BookAlreadyExistsException("O livro já existe!"));
                    }
                    return bookRepository.save(book);
                });

    }

    @Override
    public Flux<Book> list() {
        return bookRepository.findAll();
    }

    @Override
    public Mono<Book> getBySpecificId(String specificId) {
        return bookRepository.findBySpecificId(specificId)
        .switchIfEmpty(Mono.error((new BookNotFoundException("message"))));
    }

    @Override
    public Mono<Void> delete(String specificId){
        return bookRepository.deleteBySpecificId(specificId);
    }

    @Override
    public Mono<Boolean> existsBySpecificId(String specificId) {
        return bookRepository.existsBySpecificId(specificId);
    }
}

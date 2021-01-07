package br.com.saraiva.sales.book.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import br.com.saraiva.sales.book.Book;
import br.com.saraiva.sales.book.BookService;
import br.com.saraiva.sales.book.dto.ApiBookRequest;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> save(@RequestBody ApiBookRequest bookRequest){
        return bookService.save(Book.fromApiBookRequest(bookRequest));
    }

    @GetMapping
    public Flux<Book> list(){
        return bookService.list();
    }

    @GetMapping("/{specificId}")
    Mono<Book> get(@PathVariable String specificId){
        return bookService.getBySpecificId(specificId);
    }

    @DeleteMapping("/{specificId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String specificId){
        return bookService.delete(specificId);
    }
}

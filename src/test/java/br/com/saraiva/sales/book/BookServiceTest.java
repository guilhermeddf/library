package br.com.saraiva.sales.book;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import br.com.saraiva.sales.exceptions.BookAlreadyExistsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.saraiva.sales.exceptions.BookNotFoundException;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
@Tag("service")
@DisplayName("Valida funcionalidade dos serviços de livro")
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    @DisplayName("Deve salvar um livro com sucesso")
    void shouldSaveSuccessfully(){

        Book book = BookBuilder.createBook();
        
        when(bookRepository.save(any(Book.class)))
        .thenAnswer(i -> Mono.just(i.getArgument(0)));
        StepVerifier.create(bookService.save(book))
        .expectNext(book)
        .verifyComplete();
    }
    
    @Test
    @DisplayName("Deve retornar um livro")
    void shouldGetABook(){
        Book book = BookBuilder.createBook();

        when(bookRepository.findBySpecificId(anyString()))
        .thenAnswer(i -> Mono.just(i.getArgument(0)));
        StepVerifier.create(bookService.getBySpecificId(anyString()))
        .expectNext(book)
        .expectComplete().verify();
    }

    @Test
    @DisplayName("Deve retornar uma BookNotFoundException")
    void shouldThrowBookNotFoundException(){
        when(bookRepository.findBySpecificId(anyString())).thenReturn(Mono.empty());
        StepVerifier.create(bookService.getBySpecificId(anyString()))
        .expectError(BookNotFoundException.class).verify();
    }

    @Test
    @DisplayName("Deve retornar livro ja salvo com esse specific id")
    void shouldThrowBookAlreadySavedException(){
        Book book = BookBuilder.createBook();
        when(bookRepository.findBySpecificId("10010")).thenReturn(Mono.just(book));
        StepVerifier.create(bookService.save(book)).expectError(BookAlreadyExistsException.class)
        .verify();
    }
}

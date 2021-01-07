package br.com.saraiva.sales.exceptions;

public class BookNotFoundException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public BookNotFoundException(String message) {
        super(message);
    }
}


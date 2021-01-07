package br.com.saraiva.sales.exceptions;

public class BookNotSaveException extends ServiceException{
    private static final long serialVersionUID = 1L;

    public BookNotSaveException(String identifier) {
        super(identifier);
        
    }
    
}

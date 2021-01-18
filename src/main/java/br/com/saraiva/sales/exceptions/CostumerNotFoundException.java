package br.com.saraiva.sales.exceptions;

public class CostumerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CostumerNotFoundException(String message) {
        super(message);
    }
}

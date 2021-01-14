package br.com.saraiva.sales.exceptions;

public class CostumerNotFoundException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public CostumerNotFoundException(String identifier) {
        super(identifier);
    }
}

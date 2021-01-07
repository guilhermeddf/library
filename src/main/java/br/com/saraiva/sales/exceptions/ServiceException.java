package br.com.saraiva.sales.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ServiceException extends Exception {
    
    private static final long serialVersionUID = -7309911028292774285L;

    private String identifier;
    private Object[] parameters;
    private Map<String, String> errors = new HashMap<>();
    private Map<String, String> messageProperties = new HashMap<>();

    public ServiceException(String identifier) {
        super();
        this.setIdentifier(identifier);
    }

    public ServiceException(String identifier, Object[] pars) {
        super();
        this.setIdentifier(identifier);
        this.setParameters(pars);
    }

    public ServiceException(String identifier, Map<String, String> errors) {
        super();
        this.setIdentifier(identifier);
        this.setErrors(errors);
    }

    public ServiceException(String identifier, String message, Throwable cause) {
        super(message, cause);
        this.setIdentifier(identifier);
    }

    public ServiceException(String identifier, Throwable cause) {
        super(cause);
        this.setIdentifier(identifier);
    }

    public ServiceException(String identifier, String message) {
        super(message);
        this.setIdentifier(identifier);
    }

    public ServiceException addProperty(String property, String value) {
        this.getMessageProperties().put(property, value);
        return this;
    }

    public Map<String, String> getMessageProperties() {
        return messageProperties;
    }

    public ServiceException addMessage(String field, String errorKey) {
        this.errors.put(field, errorKey);
        return this;
    }

    public void setMessageProperties(Map<String, String> messageProperties) {
        this.messageProperties = messageProperties;
    }

    private void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }
   
    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

}


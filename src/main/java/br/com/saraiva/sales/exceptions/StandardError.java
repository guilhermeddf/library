package br.com.saraiva.sales.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class StandardError {

    private String message;
    private Map<String, String> messageProperties = new HashMap<>();
    private Map<String, String> errors = new HashMap<>();

}

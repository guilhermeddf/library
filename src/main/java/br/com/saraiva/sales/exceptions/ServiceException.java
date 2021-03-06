package br.com.saraiva.sales.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ControllerAdvice
@RequiredArgsConstructor
public class ServiceException extends RuntimeException {

    private String message;
    private Map<String, String> messageProperties = new HashMap<>();
    private Map<String, String> errors = new HashMap<>();


}

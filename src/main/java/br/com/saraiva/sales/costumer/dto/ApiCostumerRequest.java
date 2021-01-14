package br.com.saraiva.sales.costumer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ApiCostumerRequest {

    private String firstName;
    private String lastName;
    private String cpf;
    private String specificId;
    
}

package br.com.saraiva.sales.costumer;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.saraiva.sales.costumer.dto.ApiCostumerRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "costumers")
public class Costumer implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String cpf;
    private String specificId;

    public static Costumer fromApiCostumerRequest(ApiCostumerRequest apiCostumerRequest){
        return Costumer.builder()
        .firstName(apiCostumerRequest.getFirstName())
        .lastName(apiCostumerRequest.getLastName())
        .cpf(apiCostumerRequest.getCpf())
        .specificId(apiCostumerRequest.getSpecificId())
        .build();
    }
}
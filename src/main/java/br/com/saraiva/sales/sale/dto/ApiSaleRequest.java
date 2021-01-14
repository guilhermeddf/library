package br.com.saraiva.sales.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class ApiSaleRequest {

    private List<String> bookSpecificId;
    private String costumerSpecificId;

}

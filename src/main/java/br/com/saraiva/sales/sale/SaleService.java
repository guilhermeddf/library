package br.com.saraiva.sales.sale;

import br.com.saraiva.sales.sale.dto.ApiSaleRequest;
import reactor.core.publisher.Mono;


public interface SaleService {

    Mono<Sale> run(ApiSaleRequest apiSaleRequest);
    
}

package br.com.saraiva.sales.sale;

import br.com.saraiva.sales.sale.dto.ApiSaleRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface SaleService {

    Mono<Sale> run(ApiSaleRequest apiSaleRequest);
    
}

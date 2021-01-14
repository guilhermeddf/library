package br.com.saraiva.sales.sale;

import br.com.saraiva.sales.sale.dto.ApiSaleRequest;
import reactor.core.publisher.Mono;

public class SaleServiceImpl implements SaleService{

    @Override
    public Mono<Sale> run(ApiSaleRequest apiSaleRequest) {
        return null;
    }
}

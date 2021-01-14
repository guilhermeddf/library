package br.com.saraiva.sales.sale.v1;

import br.com.saraiva.sales.sale.Sale;
import br.com.saraiva.sales.sale.SaleService;
import br.com.saraiva.sales.sale.dto.ApiSaleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Sale> run(@RequestBody ApiSaleRequest apiSaleRequest){
        return saleService.run(apiSaleRequest);
    }

    
}

package br.com.saraiva.sales.sale;

import br.com.saraiva.sales.book.BookService;
import br.com.saraiva.sales.costumer.Costumer;
import br.com.saraiva.sales.costumer.CostumerService;
import br.com.saraiva.sales.exceptions.CostumerNotFoundException;
import br.com.saraiva.sales.sale.dto.ApiSaleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService{

    private final SaleRepository saleRepository;
    private final CostumerService costumerService;
    private final BookService bookService;

    @Override
    public Mono<Sale> run(ApiSaleRequest apiSaleRequest) {

        Mono<Costumer> costumer = costumerService.getBySpecificId(apiSaleRequest
                .getCostumerSpecificId())
                .switchIfEmpty(Mono.error(new CostumerNotFoundException("O cara não foi encontrado!")));


           // verifyCostumerCredit(c)

        return null;
    }

    private Long setSaleTotal(List<Long> booksPrice){
        Long sum = 0L;
        for (Long price : booksPrice) {
            sum = sum + price;
        }
        return sum;
    }

    private Mono<Boolean> verifyCostumerCredit(String specificId, Long total){
        return costumerService.findCreditBySpecificId(specificId).flatMap(c -> {
            if (c < total){
                return Mono.just(false);
            }
            return Mono.just(true);
        });
    }
}

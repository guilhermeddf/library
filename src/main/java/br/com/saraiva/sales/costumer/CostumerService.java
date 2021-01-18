package br.com.saraiva.sales.costumer;

import br.com.saraiva.sales.costumer.dto.ApiCostumerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CostumerService {

    Mono<Costumer> save (Costumer costumer);
    Flux<Costumer> list();
    Mono<Costumer> updateCostumer(String specificId, ApiCostumerRequest apiCostumerRequest);
    Mono<Costumer> getBySpecificId(String specificId);
    Mono<Void> deleteBySpecificId(String specificId);
    Mono<Long> findCreditBySpecificId(String specificId);
}

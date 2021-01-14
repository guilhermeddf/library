package br.com.saraiva.sales.sale;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface SaleRepository extends ReactiveMongoRepository<Sale, String> {

    Mono<Sale> save(Sale sale);
}

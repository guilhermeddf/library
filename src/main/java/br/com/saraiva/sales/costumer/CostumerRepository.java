package br.com.saraiva.sales.costumer;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface CostumerRepository extends ReactiveMongoRepository<Costumer, String>{
    
    Mono<Costumer> findBySpecificId(String specificId);
    Mono<Void> deleteBySpecificId(String specificId);
    Mono<Costumer> save(Costumer costumer);
}
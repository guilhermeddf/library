package br.com.saraiva.sales.costumer;

import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CostumerServiceImpl implements CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;

    @Override
    public Mono<Costumer> save(Costumer costumer) {
        return costumerRepository.save(costumer);
    }

    @Override
    public Flux<Costumer> list() {
        return costumerRepository.findAll();
    }

    @Override
    public Mono<Costumer> updateCostumer(String specificId) {
        return costumerRepository.findBySpecificId(specificId);
        //TODO fazer o update dos dados
    }

    @Override
    public Mono<Costumer> getBySpecificId(String specificId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<Void> deleteBySpecificId(String specificId) {
        return costumerRepository.deleteBySpecificId(specificId);
    }
}

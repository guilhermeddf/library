package br.com.saraiva.sales.costumer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saraiva.sales.costumer.dto.ApiCostumerRequest;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CostumerServiceImpl implements CostumerService {

    private final CostumerRepository costumerRepository;

    @Override
    public Mono<Costumer> save(Costumer costumer) {
        return costumerRepository.save(costumer);
    }

    @Override
    public Flux<Costumer> list() {
        return costumerRepository.findAll();
    }

    
    @Override
    public Mono<Costumer> updateCostumer(String specificId, ApiCostumerRequest costumerRequest){
       /*
        Costumer c =  costumerRepository.findBySpecificId(specificId)
        .switchIfEmpty(Mono.error(new CostumerNotFoundException("identifier"))).flatMap(p -> );
         fazer o update dos dados */
        return null;
    }



    @Override
    public Mono<Costumer> getBySpecificId(String specificId) {
        return costumerRepository.findBySpecificId(specificId);
    }

    @Override
    public Mono<Void> deleteBySpecificId(String specificId) {
        return costumerRepository.deleteBySpecificId(specificId);
    }

    @Override
    public Mono<Long> findCreditBySpecificId(String specificId) {
        return null;
    }
}

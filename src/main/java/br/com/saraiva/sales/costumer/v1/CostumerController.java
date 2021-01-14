package br.com.saraiva.sales.costumer.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.com.saraiva.sales.costumer.Costumer;
import br.com.saraiva.sales.costumer.CostumerService;
import br.com.saraiva.sales.costumer.dto.ApiCostumerRequest;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/api/v1/costumers")
@RequiredArgsConstructor
public class CostumerController {

    private final CostumerService costumerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Costumer> save(@RequestBody ApiCostumerRequest costumerRequest){
        return costumerService.save(Costumer.fromApiCostumerRequest(costumerRequest));
    }

    @GetMapping(value = "/{specificId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Costumer> get(@RequestParam String specificId){
        return costumerService.getBySpecificId(specificId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Costumer> list(){
        return costumerService.list();
    }

    @DeleteMapping(value = "specificId/delete")
    public Mono<Void> delete(@RequestParam String specificId){
        return costumerService.deleteBySpecificId(specificId);
    }
}

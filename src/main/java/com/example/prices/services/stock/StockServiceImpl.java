package com.example.prices.services.stock;

import com.example.prices.models.Pair;
import com.example.prices.models.Stock;
import com.example.prices.models.dict.Exchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class StockServiceImpl implements StockService {


    @Override
    public Mono<Stock> getStock(Pair pair, Exchange exchange) {
        return Mono.empty();
    }
}


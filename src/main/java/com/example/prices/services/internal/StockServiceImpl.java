package com.example.prices.services.internal;

import com.example.prices.models.Stock;
import com.example.prices.models.Symbol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class StockServiceImpl implements StockService {

    @Override
    public Mono<Stock> getStockByPair(Symbol left, Symbol right) {
        // todo
        return null;
    }
}
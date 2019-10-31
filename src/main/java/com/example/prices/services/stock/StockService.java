package com.example.prices.services.stock;

import com.example.prices.models.Pair;
import com.example.prices.models.Stock;
import com.example.prices.models.dict.Exchange;
import reactor.core.publisher.Mono;

public interface StockService {
    Mono<Stock> getStock(Pair pair, Exchange exchange);
}

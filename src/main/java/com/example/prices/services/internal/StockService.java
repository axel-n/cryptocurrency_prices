package com.example.prices.services.internal;

import com.example.prices.models.Stock;
import com.example.prices.models.Symbol;
import reactor.core.publisher.Mono;

public interface StockService {
    Mono<Stock> getStockByPair(Symbol left, Symbol right);
}

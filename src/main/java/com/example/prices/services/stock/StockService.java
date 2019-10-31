package com.example.prices.services.stock;

import com.example.prices.models.Stock;
import com.example.prices.models.dict.Symbol;
import reactor.core.publisher.Mono;

public interface StockService {
    Mono<Stock> getStockByPair(Symbol left, Symbol right);
}

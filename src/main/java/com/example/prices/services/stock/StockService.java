package com.example.prices.services.stock;

import com.example.prices.models.Pair;
import com.example.prices.models.dict.Exchange;

public interface StockService {
    void getStock(Pair pair, Exchange exchange);
}

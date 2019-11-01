package com.example.prices.services.exchange;

import com.example.prices.models.Pair;

public interface ExchangeService {
    void subscribe(Pair pair);
}

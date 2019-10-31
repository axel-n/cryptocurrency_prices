package com.example.prices.services.exchange;

import com.example.prices.models.Pair;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface ExchangeService {
    Mono<BigDecimal> getPriceByPair(Pair pair);
}

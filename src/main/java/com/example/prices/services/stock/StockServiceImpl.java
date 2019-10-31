package com.example.prices.services.stock;

import com.example.prices.models.Pair;
import com.example.prices.models.dict.Exchange;
import com.example.prices.services.exchange.ExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StockServiceImpl implements StockService {


    private final ExchangeService liquidExchange;

    public StockServiceImpl(ExchangeService liquidExchange) {
        this.liquidExchange = liquidExchange;
    }


    @Override
    public void getStock(Pair pair, Exchange exchange) {
        liquidExchange.getPriceByPair(pair);
    }
}


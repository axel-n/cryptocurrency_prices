package com.example.prices.services.stock;

import com.example.prices.models.Pair;
import com.example.prices.models.dict.Exchange;
import com.example.prices.services.exchange.ExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StockServiceImpl implements StockService {

    private final ExchangeService liquidExchange;
    private final ExchangeService bitmexExchange;

    public StockServiceImpl(@Qualifier("liquidExchange") ExchangeService liquidExchange,
                            @Qualifier("bitMexExchange") ExchangeService bitmexExchange) {
        this.liquidExchange = liquidExchange;
        this.bitmexExchange = bitmexExchange;
    }


    @Override
    public void subscribe(Pair pair, Exchange exchange) {

        switch (exchange) {
            case BitMEX:
                bitmexExchange.subscribe(pair);
                break;

            case Liquid:
                liquidExchange.subscribe(pair);
                break;

            default:
                log.error("unknown exchange!");
                break;
        }
    }
}


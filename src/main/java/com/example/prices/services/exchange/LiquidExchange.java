package com.example.prices.services.exchange;

import com.example.prices.models.Pair;
import com.example.prices.models.dict.Symbol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class LiquidExchange implements ExchangeService {

    public LiquidExchange() {
        pairsById.put(new Pair(Symbol.BTC, Symbol.JPY), 5);
        pairsById.put(new Pair(Symbol.BTC, Symbol.USD), 1);
    }

    @Override
    public void subscribe(Pair pair) {

        Integer pairId = pairsById.get(pair);

        if (pairId != null) {

            // TODO this
            log.warn("not implemented");

        } else {
            log.error("unknown pair!");
        }
    }

    private BigDecimal getAvgPrice(BigDecimal marketAsk, BigDecimal marketBid) {
        return marketAsk.add(marketBid).divide(new BigDecimal("2"), RoundingMode.HALF_UP);
    }

    @Value("${liquid.ws.root}")
    private String apiRoot;



    // у биржи нельзя искать по паре, только по id
    private final Map<Pair, Integer> pairsById = new HashMap<>();

}

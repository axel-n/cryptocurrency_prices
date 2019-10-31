package com.example.prices.services.exchange;

import com.example.prices.models.Pair;
import com.example.prices.models.dict.Symbol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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
    public Mono<BigDecimal> getPriceByPair(Pair pair) {

        Integer pairId = pairsById.get(pair);

        if (pairId != null) {

            String pairExchangeUrl = "/products/";
            String url = pairExchangeUrl + pairId;

            return webClient.get()
                    .uri(apiRoot + url)
                    .accept(MediaType.APPLICATION_JSON)
                    .exchange()
                    .filter(response -> !response.statusCode().isError())
                    .flatMap(body -> body.bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {
                    }))
                    .map(map -> {
                        BigDecimal marketAsk = new BigDecimal(map.get("market_ask"));
                        BigDecimal marketBid = new BigDecimal(map.get("market_bid"));

                        return getAvgPrice(marketAsk, marketBid);
                    });

        } else {
            log.error("unknown pair!");
            return Mono.just(new BigDecimal("0"));
        }
    }

    private BigDecimal getAvgPrice(BigDecimal marketAsk, BigDecimal marketBid) {
        return marketAsk.add(marketBid).divide(new BigDecimal("2"), RoundingMode.HALF_UP);
    }

    @Value("${liquid.apiRoot}")
    private String apiRoot;


    private final WebClient webClient = WebClient.create();

    // у биржи нельзя искать по паре, только по id
    private final Map<Pair, Integer> pairsById = new HashMap<>();



}

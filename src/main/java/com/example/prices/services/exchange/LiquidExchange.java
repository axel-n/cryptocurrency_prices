package com.example.prices.services.exchange;

import com.example.prices.models.Pair;
import com.example.prices.models.dict.Symbol;
import com.example.prices.websocket.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;
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
    public void getPriceByPair(Pair pair) {

        Integer pairId = pairsById.get(pair);

        if (pairId != null) {

            try {
                Client client = new Client(new URI("wss://www.bitmex.com/realtime?subscribe=instrument,orderBook:XBTUSD"));
                client.connect();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }



//            System.out.println(String.format("Exchange: %s. pair: %s-%s - price: %s",
//                    exchange, pair.getLeft(), pair.getRight(), stock.getPrice()));


        } else {
            log.error("unknown pair!");
        }
    }

    private BigDecimal getAvgPrice(BigDecimal marketAsk, BigDecimal marketBid) {
        return marketAsk.add(marketBid).divide(new BigDecimal("2"), RoundingMode.HALF_UP);
    }

    @Value("${liquid.apiRoot}")
    private String apiRoot;


    private final WebSocketClient client = new ReactorNettyWebSocketClient();

    // у биржи нельзя искать по паре, только по id
    private final Map<Pair, Integer> pairsById = new HashMap<>();


}

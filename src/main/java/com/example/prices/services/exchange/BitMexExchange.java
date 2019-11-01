package com.example.prices.services.exchange;

import com.example.prices.models.Pair;
import com.example.prices.websocket.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Service
public class BitMexExchange implements ExchangeService {

    @Override
    public void subscribe(Pair pair) {

        String url = wsRoot + wsPrefix + pair.getLeft() + pair.getRight();
        try {
            Client client = new Client(new URI(url));
            client.connect();
        } catch (URISyntaxException e) {
            log.error("{}", e.getMessage());
            e.printStackTrace();
        }
    }

    @Value("${bitmex.ws.root}")
    private String wsRoot;

    @Value("${bitmex.ws.prefix}")
    private String wsPrefix;

}

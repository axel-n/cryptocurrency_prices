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
public class LiquidExchange implements ExchangeService {

    @Override
    public void subscribe(Pair pair) {

        String pairToSend = (pair.getLeft().toString() + pair.getRight().toString()).toLowerCase();

            String url = wsRoot;
            try {
                Client client = new Client(new URI(url));
                client.connectBlocking();
                client.send( String.format(channelTemplate, pairToSend) );

            } catch (URISyntaxException | InterruptedException e) {
                log.error("{}", e.getMessage());
                e.printStackTrace();
            }
    }

    @Value("${liquid.ws.root}")
    private String wsRoot;

    private final String channelTemplate = "{\"event\":\"pusher:subscribe\",\"data\":{\"channel\":\"product_cash_%s_5\"}}";
}

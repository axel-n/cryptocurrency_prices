package com.example.prices.websocket;/*


import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

/** This example demonstrates how to create a websocket connection to a server. Only the most important callbacks are overloaded. */

import com.example.prices.models.dict.Exchange;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

@Slf4j
public class Client extends WebSocketClient {
    private final ObjectMapper OM = new ObjectMapper();
    private final Exchange exchange;

    public Client(URI uri, Exchange exchange) {
        super(uri);
        this.exchange = exchange;
    }

    @Override
    public void onOpen(ServerHandshake data) {
        log.info("opened connection");
    }

    @Override
    public void onMessage(String message) {
        log.info("exchange {}. receive message {}", exchange, message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {

        String remoteText = remote ? "remote peer" : "us";
        log.info(String.format("Connection closed by %s, code: %s, reason: %s", remoteText, code, reason));
    }

    @Override
    public void onError(Exception ex) {
        log.error("{}", ex.getMessage());
    }
}

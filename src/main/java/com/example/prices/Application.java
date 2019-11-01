package com.example.prices;

import com.example.prices.models.Pair;
import com.example.prices.models.dict.Exchange;
import com.example.prices.models.dict.Symbol;
import com.example.prices.services.stock.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Override
    public void run(String... args) {

        stockService.subscribe(BTC_JPY, Exchange.Liquid);
        stockService.subscribe(BTC_USD, Exchange.Liquid);

        stockService.subscribe(XBT_USD, Exchange.BitMEX);
        stockService.subscribe(BTC_USD, Exchange.BitMEX);
    }

    private final StockService stockService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public Application(StockService stockService) {
        this.stockService = stockService;
    }

    private final Pair XBT_USD = new Pair(Symbol.XBT, Symbol.USD);
    private final Pair BTC_JPY = new Pair(Symbol.BTC, Symbol.JPY);
    private final Pair BTC_USD = new Pair(Symbol.BTC, Symbol.USD);

}

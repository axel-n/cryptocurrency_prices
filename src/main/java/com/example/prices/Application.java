package com.example.prices;

import com.example.prices.models.Pair;
import com.example.prices.models.dict.Exchange;
import com.example.prices.models.dict.Symbol;
import com.example.prices.services.stock.StockService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {

    public Application(StockService stockService) {
        this.stockService = stockService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private final StockService stockService;

    @Override
    public void run(String... args) {

        Pair pair = new Pair(Symbol.BTC, Symbol.JPY);
        Exchange exchange = Exchange.Liquid;

         stockService.getStock(new Pair(Symbol.BTC, Symbol.JPY), Exchange.Liquid)
                .doOnNext(stock -> {

                    System.out.println(String.format("Exchange: %s. pair: %s %s - price: %s",
                            exchange, pair.getLeft(), pair.getRight(), stock.getPrice()));
                });

    }
}

package com.example.prices.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Stock {
    private Pair pair;
    private BigDecimal price;

    public Stock(Pair pair) {
        this.pair = pair;
    }
}

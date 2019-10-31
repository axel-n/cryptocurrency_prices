package com.example.prices.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Stock {
    private Pair pair;
    private BigDecimal price;
}

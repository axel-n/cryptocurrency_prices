package com.example.prices.models;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    private Pair<Symbol, Symbol> pair;
    private BigDecimal price;
}

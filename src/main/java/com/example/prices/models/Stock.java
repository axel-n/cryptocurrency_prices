package com.example.prices.models;

import com.example.prices.models.dict.Symbol;
import javafx.util.Pair;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Stock {
    private Pair<Symbol, Symbol> pair;
    private BigDecimal price;

    public Stock(Pair<Symbol, Symbol> pair) {
        this.pair = pair;
    }
}

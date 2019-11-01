package com.example.prices.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class priceUtils {

    private BigDecimal getAvgPrice(BigDecimal marketAsk, BigDecimal marketBid) {
        return marketAsk.add(marketBid).divide(new BigDecimal("2"), RoundingMode.HALF_UP);
    }
}

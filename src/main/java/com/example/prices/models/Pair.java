package com.example.prices.models;

import com.example.prices.models.dict.Symbol;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pair {

    private Symbol left;
    private Symbol right;
}

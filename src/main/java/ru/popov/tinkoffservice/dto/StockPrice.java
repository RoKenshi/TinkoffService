package ru.popov.tinkoffservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StockPrice {
    private String figi;
    private Double price;
}
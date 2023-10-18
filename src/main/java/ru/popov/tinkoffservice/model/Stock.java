package ru.popov.tinkoffservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;


@NoArgsConstructor
@Data
public class Stock {
    String ticker;
    String figi;
    String name;
    String type;
//    Currency Currency;
    String source;

    public Stock(String ticker, String figi, String name, String type, String source) {
        this.ticker = ticker;
        this.figi = figi;
        this.name = name;
        this.type = type;
//        Currency = currency;
        this.source = source;
    }
}

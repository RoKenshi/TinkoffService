package ru.popov.tinkoffservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class StocksPricesDto {
    private List<StockPrice> prices;
}

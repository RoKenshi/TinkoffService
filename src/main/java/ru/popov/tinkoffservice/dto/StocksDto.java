package ru.popov.tinkoffservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.popov.tinkoffservice.model.Stock;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StocksDto {
    List<Stock> stocks;
}

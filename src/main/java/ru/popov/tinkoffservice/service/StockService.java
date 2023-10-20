package ru.popov.tinkoffservice.service;

import ru.popov.tinkoffservice.dto.FigiesDto;
import ru.popov.tinkoffservice.dto.StocksDto;
import ru.popov.tinkoffservice.dto.StocksPricesDto;
import ru.popov.tinkoffservice.dto.TickersDto;
import ru.popov.tinkoffservice.model.Stock;

import java.util.List;


public interface StockService {
    List<Stock> getStockByTicker(String ticker);

    StocksPricesDto getPricesStocksByFigies(FigiesDto figiesDto);

    StocksDto getStocksByTickers(TickersDto tickers);
}

package ru.popov.tinkoffservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.popov.tinkoffservice.model.Stock;
import ru.popov.tinkoffservice.service.StockService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/stocks/{ticker}")
    public ResponseEntity<List<Stock>> getStock(@PathVariable String ticker) {
        List<Stock> stockByTicker = stockService.getStockByTicker(ticker);

        return new ResponseEntity<>(stockByTicker, HttpStatus.OK);
    }
}

package ru.popov.tinkoffservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.popov.tinkoffservice.dto.FigiesDto;
import ru.popov.tinkoffservice.dto.StocksDto;
import ru.popov.tinkoffservice.dto.StocksPricesDto;
import ru.popov.tinkoffservice.dto.TickersDto;
import ru.popov.tinkoffservice.model.Stock;
import ru.tinkoff.piapi.contract.v1.InstrumentShort;
import ru.tinkoff.piapi.contract.v1.LastPrice;
import ru.tinkoff.piapi.core.InvestApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.tinkoff.piapi.core.utils.DateUtils.timestampToString;
import static ru.tinkoff.piapi.core.utils.MapperUtils.quotationToBigDecimal;


@Service
public class TinkoffStockService implements StockService{



    private final InvestApi investApi;

    @Autowired
    public TinkoffStockService(InvestApi investApi) {
        this.investApi = investApi;
    }

    @Override
    public List<Stock> getStockByTicker(String ticker) {

        List<InstrumentShort> instrumentList = investApi.getInstrumentsService().findInstrumentSync(ticker);
        List<Stock> stockList = new ArrayList<>();
        int counter = 0;

//        instrumentList.forEach(x -> System.out.println(String.format("Name: %s | Ticker: %s | Figi: %s | TypeInstrument| %s", x.getName(), x.getTicker(), x.getFigi(), x.getInstrumentType())));
        for(InstrumentShort instrumentShort : instrumentList) {
            if(instrumentShort.getInstrumentType().equals("share")) {
                String instrumentShortName = instrumentShort.getName();
                var lastPrices = investApi.getMarketDataService()
                        .getLastPricesSync(Collections.singletonList(instrumentShort.getFigi()));
                Long price = quotationToBigDecimal(lastPrices.get(0).getPrice()).longValue();
                var time = timestampToString(lastPrices.get(0).getTime());
                System.out.println(String.format("%s Price: %d | Time| %s",instrumentShortName, price, time));
                stockList.add(new Stock(
                        instrumentList.get(counter).getTicker(),
                        instrumentList.get(counter).getFigi(),
                        instrumentList.get(counter).getName(),
                        instrumentList.get(counter).getInstrumentType(),
                        "TINKOFF"));
            }
            counter++;
        }

        return stockList;
    }

    @Override
    public StocksPricesDto getPricesStocksByFigies(FigiesDto figiesDto) {
        return null;
    }

    @Override
    public StocksDto getStocksByTickers(TickersDto tickers) {
        return null;
    }

//    private static void getLastPricesExample(InvestApi api) {
//
//        //Получаем и печатаем последнюю цену по инструменту
//        var lastPrices = api.getMarketDataService().getLastPricesSync(randomFigi);
//        for (LastPrice lastPrice : lastPrices) {
//            var figi = lastPrice.getFigi();
//            var price = quotationToBigDecimal(lastPrice.getPrice());
//            var time = timestampToString(lastPrice.getTime());
//            log.info("последняя цена по инструменту {}, цена: {}, время обновления цены: {}", figi, price, time);
//        }
//
//    }

    private static void getLastPricesExample(InvestApi api, List<String> lastPricesList) {

        //Получаем и печатаем последнюю цену по инструменту
        List<LastPrice> lastPriceList = api.getMarketDataService().getLastPricesSync(lastPricesList);
        for (LastPrice lastPrice : lastPriceList) {
            System.out.println(lastPrice);
    }

    }
}

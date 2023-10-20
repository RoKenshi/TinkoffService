package ru.popov.tinkoffservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ru.popov.tinkoffservice.dto.FigiesDto;
import ru.popov.tinkoffservice.dto.StocksDto;
import ru.popov.tinkoffservice.dto.StocksPricesDto;
import ru.popov.tinkoffservice.dto.TickersDto;
import ru.popov.tinkoffservice.mappers.TinkoffStockMapper;
import ru.popov.tinkoffservice.model.Stock;
import ru.tinkoff.piapi.contract.v1.InstrumentShort;
import ru.tinkoff.piapi.contract.v1.LastPrice;
import ru.tinkoff.piapi.core.InvestApi;

import java.util.List;
import java.util.stream.Collectors;



@RequiredArgsConstructor
@Service
public class TinkoffStockService implements StockService{

    private final String SHARE_TYPE = "share";
    private final InvestApi investApi;
    private final TinkoffStockMapper stockMapper;


    @Override
    public List<Stock> getStockByTicker(String ticker) {
        List<InstrumentShort> instrumentList = investApi.getInstrumentsService().findInstrumentSync(ticker);
        return instrumentList.stream()
                .filter(instrument -> instrument.getInstrumentType().equals(SHARE_TYPE))
                .map(stockMapper::InstrumentToStock)
                .collect(Collectors.toList());
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

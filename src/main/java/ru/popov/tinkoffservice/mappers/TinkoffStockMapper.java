package ru.popov.tinkoffservice.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.popov.tinkoffservice.model.Stock;
import ru.tinkoff.piapi.contract.v1.InstrumentShort;

import javax.sound.midi.Instrument;

@Mapper
public interface TinkoffStockMapper {

    String TINKOFF_STOCK_SOURCE = "TINKOFF";

    @Mapping(target = "type", source = "instrumentType")
    @Mapping(target = "source", constant = TINKOFF_STOCK_SOURCE)
    Stock InstrumentToStock(InstrumentShort instrumentShort);
}

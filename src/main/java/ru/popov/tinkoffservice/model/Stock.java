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
    String source;

}

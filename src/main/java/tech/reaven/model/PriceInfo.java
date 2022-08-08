package tech.reaven.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PriceInfo {
    private String stockExchange;// börse in json file
    private String lastUpdate;// update in json file
    private BigDecimal bid;// geld
    private int bidVolume;// geldStk
    private BigDecimal offer;//brief
    private int offerVolume;//briefStk
    private String spreadPercentage;// spredPercentage --> Spread (in %) in Quotrix
    private BigDecimal lastTradedPrice;// letzter
    private float changePercentage;// anderung
    private String stand;// stand ISO DATE
    private BigDecimal opening;// eröffnung
    private BigDecimal previousClosing;// vortag
    private int tradedVolume;// gehandeltStücke
    private float tradedAmount;// gehandeltUmsatz
    private BigDecimal dailyHigh;// tageschoch
    private BigDecimal dailyLow;// tagetief
    private BigDecimal high52w;
    private String high52wDate;// 52wHoch
    private BigDecimal low52w;
    private String low52wDate;// 52wTief
}

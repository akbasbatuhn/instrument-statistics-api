package tech.reaven.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@ToString
//@Entity
//@Table(name = "price_info")
@Embeddable
public class PriceInfo {
//    @Id
//    @Column
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    //@Column(length = 25)
    private String stockExchange;// börse in json file
    private String lastUpdate;// update in json file
    private BigDecimal bid;// geld
    private int bidVolume;// geldStk
    private BigDecimal offer;//brief
    private int offerVolume;//briefStk
    private String spreadPercentage;// spredPercentage --> Spread (in %)
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

//    @OneToOne(mappedBy = "priceInfo")
//    private Stock stock;

    public PriceInfo(String stockExchange, String lastUpdate,
                     BigDecimal bid, int bidVolume,
                     BigDecimal offer, int offerVolume,
                     String spreadPercentage, BigDecimal lastTradedPrice,
                     float changePercentage, String stand, BigDecimal opening,
                     BigDecimal previousClosing, int tradedVolume, float tradedAmount,
                     BigDecimal dailyHigh, BigDecimal dailyLow, BigDecimal high52w,
                     String high52wDate, BigDecimal low52w, String low52wDate) {
        this.stockExchange = stockExchange;
        this.lastUpdate = lastUpdate;
        this.bid = bid;
        this.bidVolume = bidVolume;
        this.offer = offer;
        this.offerVolume = offerVolume;
        this.spreadPercentage = spreadPercentage;
        this.lastTradedPrice = lastTradedPrice;
        this.changePercentage = changePercentage;
        this.stand = stand;
        this.opening = opening;
        this.previousClosing = previousClosing;
        this.tradedVolume = tradedVolume;
        this.tradedAmount = tradedAmount;
        this.dailyHigh = dailyHigh;
        this.dailyLow = dailyLow;
        this.high52w = high52w;
        this.high52wDate = high52wDate;
        this.low52w = low52w;
        this.low52wDate = low52wDate;
    }
}

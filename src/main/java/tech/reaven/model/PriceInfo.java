package tech.reaven.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@Embeddable
public class PriceInfo {
    @Column(name = "exchange")
    private String exchange;// börse in json file
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "last_update")
    private Date lastUpdate;// update in json file
    @Column(name = "bid")
    private BigDecimal bid;// geld
    @Column(name = "bid_volume")
    private int bidVolume;// geldStk
    @Column(name = "offer")
    private BigDecimal offer;//brief
    @Column(name = "offer_volume")
    private int offerVolume;//briefStk
    @Column(name = "spread_percentage")
    private String spreadPercentage;// spredPercentage --> Spread (in %)
    @Column(name = "last_traded_price")
    private BigDecimal lastTradedPrice;// letzter
    @Column(name = "change_percentage")
    private float changePercentage;// anderung
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "stand")
    private Date stand;// stand - ISO DATE
    @Column(name = "opening")
    private BigDecimal opening;// eröffnung
    @Column(name = "previous_closing")
    private BigDecimal previousClosing;// vortag
    @Column(name = "traded_volume")
    private int tradedVolume;// gehandeltStücke
    @Column(name = "traded_amount")
    private BigDecimal tradedAmount;// gehandeltUmsatz
    @Column(name = "daily_high")
    private BigDecimal dailyHigh;// tageschoch
    @Column(name = "daily_low")
    private BigDecimal dailyLow;// tagetief
    @Column(name = "high52w")
    private BigDecimal high52w;
    @Column(name = "high52w_date")
    private String high52wDate;// 52wHoch
    @Column(name = "low52w")
    private BigDecimal low52w;
    @Column(name = "low52w_date")
    private String low52wDate;// 52wTief

    public PriceInfo(String exchange, Date lastUpdate,
                     BigDecimal bid, int bidVolume,
                     BigDecimal offer, int offerVolume,
                     String spreadPercentage, BigDecimal lastTradedPrice,
                     float changePercentage, Date stand, BigDecimal opening,
                     BigDecimal previousClosing, int tradedVolume, BigDecimal tradedAmount,
                     BigDecimal dailyHigh, BigDecimal dailyLow, BigDecimal high52w,
                     String high52wDate, BigDecimal low52w, String low52wDate) {
        this.exchange = exchange;
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

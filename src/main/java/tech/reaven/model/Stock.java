package tech.reaven.model;

import lombok.*;
import org.springframework.boot.jackson.JsonComponent;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Stocks")
public class Stock {
    @Id
    @Column(name = "isincode")
    private String isinCode;

    @Column(nullable = false, length = 45)
    private String name;

    @Embedded
    private PriceInfo priceInfo;

    @Embedded
    private BaseData baseData;

    @Embedded
    private FundamentalData fundamentalData;

    @Column(length = 255, columnDefinition = "TEXT")
    private String portrait;

    public Stock(String isinCode, String name, PriceInfo priceInfo,
                 BaseData baseData, FundamentalData fundamentalData, String portrait) {
        this.isinCode = isinCode;
        this.name = name;
        this.priceInfo = priceInfo;
        this.baseData = baseData;
        this.fundamentalData = fundamentalData;
        this.portrait = portrait;
    }
}

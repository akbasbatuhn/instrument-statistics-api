package tech.reaven.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Stocks")
public class Stock {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, length = 45)
    private String stockName;

    //@OneToOne(cascade = CascadeType.ALL)
    @Embedded
    //@JoinColumn(name = "price_info_id", referencedColumnName = "id")
    private PriceInfo priceInfo;

//    @OneToOne(cascade = CascadeType.ALL)
    @Embedded
    //@JoinColumn(name = "base_data_id", referencedColumnName = "id")
    private BaseData baseData;

//    @OneToOne(cascade = CascadeType.ALL)
    @Embedded
    //@JoinColumn(name = "fundamental_data_id", referencedColumnName = "id")
    private FundamentalData fundamentalData;

    @Column(length = 512)
    private String portrait;

    public Stock(String stockName, PriceInfo priceInfo,
                 BaseData baseData, FundamentalData fundamentalData, String portrait) {
        this.stockName = stockName;
        this.priceInfo = priceInfo;
        this.baseData = baseData;
        this.fundamentalData = fundamentalData;
        this.portrait = portrait;
    }
}

package tech.reaven.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Stocks", schema = "dbo")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(columnDefinition = "char(30)")
    private String stockName;

    @Column(columnDefinition = "")
    private PriceInfo priceInfo;

    @Column
    private BaseData baseData;

    @Column
    private FundamentalData fundamentalData;

    @Column(columnDefinition = "char(256)")
    private String portrait;
}

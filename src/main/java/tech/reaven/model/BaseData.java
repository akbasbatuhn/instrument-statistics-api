package tech.reaven.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
//@Entity
//@Table(name = "base_data")
@Embeddable
public class BaseData {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    private String securityType;
    private String stockISIN;
    private String stockWKN;
    private String currency;
    private String initialListingDate;
    private String foundingYear;
    private String fiscalDate;

//    @OneToOne(mappedBy = "baseData")
//    private Stock stock;

    public BaseData(String securityType, String stockISIN, String stockWKN,
                    String currency, String initialListingDate,
                    String foundingYear, String fiscalDate) {
        this.securityType = securityType;
        this.stockISIN = stockISIN;
        this.stockWKN = stockWKN;
        this.currency = currency;
        this.initialListingDate = initialListingDate;
        this.foundingYear = foundingYear;
        this.fiscalDate = fiscalDate;
    }
}

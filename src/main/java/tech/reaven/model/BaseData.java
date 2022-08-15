package tech.reaven.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Embeddable
public class BaseData {
    @Column(name = "security_type")
    private String securityType;
    @Column(name = "wkn")
    private String wkn;
    @Column(name = "currency")
    private String currency;
    @Column(name = "initial_listing_date")
    private String initialListingDate;
    @Column(name = "founding_year")
    private String foundingYear;
    @Column(name = "fiscal_date")
    private String fiscalDate;


    public BaseData(String securityType, String wkn,
                    String currency, String initialListingDate,
                    String foundingYear, String fiscalDate) {
        this.securityType = securityType;
        this.wkn = wkn;
        this.currency = currency;
        this.initialListingDate = initialListingDate;
        this.foundingYear = foundingYear;
        this.fiscalDate = fiscalDate;
    }
}

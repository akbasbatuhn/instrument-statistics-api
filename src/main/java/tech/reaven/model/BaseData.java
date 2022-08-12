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

    private String securityType;
    private String wkn;
    private String currency;
    private String initialListingDate;
    private String foundingYear;
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

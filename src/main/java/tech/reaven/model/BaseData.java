package tech.reaven.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseData {
    private String securityType;
    private String stockISIN;
    private String stockWKN;
    private String currency;
    private String initialListingDate;
    private String foundingYear;
    private String fiscalDate;
}

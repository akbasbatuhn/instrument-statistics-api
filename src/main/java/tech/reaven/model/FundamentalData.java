package tech.reaven.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
//@Entity
//@Table(name = "fundamental_data")
@Embeddable
public class FundamentalData {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    private String industry;
    private long marketCapital;
    private int stockPieces;
    private long equityCapital;
    private int numberOfEmployees;
    private String lastGeneralMeeting;

//    @OneToOne(mappedBy = "fundamentalData")
//    private Stock stock;

    public FundamentalData(String industry, long marketCapital, int stockPieces,
                           long equityCapital, int numberOfEmployees, String lastGeneralMeeting) {
        this.industry = industry;
        this.marketCapital = marketCapital;
        this.stockPieces = stockPieces;
        this.equityCapital = equityCapital;
        this.numberOfEmployees = numberOfEmployees;
        this.lastGeneralMeeting = lastGeneralMeeting;
    }
}

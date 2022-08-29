package tech.reaven.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Embeddable
public class FundamentalData {
    @Column(name = "industry")
    private String industry;
    @Column(name = "market_capital")
    private long marketCapital;
    @Column(name = "pieces")
    private int pieces;
    @Column(name = "equity_capital")
    private long equityCapital;
    @Column(name = "number_of_employees")
    private int numberOfEmployees;
    @Column(name = "last_general_meeting")
    private String lastGeneralMeeting;

    public FundamentalData(String industry, long marketCapital, int pieces,
                           long equityCapital, int numberOfEmployees, String lastGeneralMeeting) {
        this.industry = industry;
        this.marketCapital = marketCapital;
        this.pieces = pieces;
        this.equityCapital = equityCapital;
        this.numberOfEmployees = numberOfEmployees;
        this.lastGeneralMeeting = lastGeneralMeeting;
    }
}

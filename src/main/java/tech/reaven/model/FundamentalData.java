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

    private String industry;
    private long marketCapital;
    private int pieces;
    private long equityCapital;
    private int numberOfEmployees;
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

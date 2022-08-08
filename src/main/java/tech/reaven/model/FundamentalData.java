package tech.reaven.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FundamentalData {
    private String industry;
    private long marketCapital;
    private int stockPieces;
    private long equityCapital;
    private int numberOfEmployees;
    private String lastGeneralMeeting;
}

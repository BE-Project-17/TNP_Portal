package com.example.tnpportal.models.user;

public class AmCatDetails {

    private Double QuantitativeScore;
    private Double LogicalReasoningScore;
    private Double EnglishProfScore;
    private Double AutomataProScore;
    private Double ComputerScienceScore;

    public AmCatDetails(Double quantitativeScore, Double logicalReasoningScore, Double englishProfScore, Double automataProScore, Double computerScienceScore) {
        QuantitativeScore = quantitativeScore;
        LogicalReasoningScore = logicalReasoningScore;
        EnglishProfScore = englishProfScore;
        AutomataProScore = automataProScore;
        ComputerScienceScore = computerScienceScore;
    }

    public Double getQuantitativeScore() {
        return QuantitativeScore;
    }

    public Double getLogicalReasoningScore() {
        return LogicalReasoningScore;
    }

    public Double getEnglishProfScore() {
        return EnglishProfScore;
    }

    public Double getAutomataProScore() {
        return AutomataProScore;
    }

    public Double getComputerScienceScore() {
        return ComputerScienceScore;
    }
}

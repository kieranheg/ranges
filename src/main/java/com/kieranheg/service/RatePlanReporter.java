package com.kieranheg.service;

import com.kieranheg.model.Premium;
import com.kieranheg.model.PremiumRange;
import com.kieranheg.model.Range;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RatePlanReporter {
    private List<Premium> premiums;
    private List<PremiumRange> premiumRanges = new ArrayList<>();
    
    public RatePlanReporter(List<Premium> premiums) {
        this.premiums = premiums;
        initRanges();
    }
    
    private void initRanges() {
        premiumRanges.add(PremiumRange.builder().range(new Range(0, 100)).build());
        premiumRanges.add(PremiumRange.builder().range(new Range(100, 500)).build());
        premiumRanges.add(PremiumRange.builder().range(new Range(500, 1000)).build());
        premiumRanges.add(PremiumRange.builder().range(new Range(1000, 1500)).build());
        premiumRanges.add(PremiumRange.builder().range(new Range(1500, 2000)).build());
    }
    
    public void buildPremiumReportRanges() {
        calculatePercentPremiumDifferences();
        movePremiumsToTheirRanges();
    }
    
    private void movePremiumsToTheirRanges() {
        for (Premium premium : premiums) {
            for (PremiumRange premiumRange : premiumRanges) {
                if (premiumRange.getRange().isInRange(premium.getPercentPremiumDifference())) {
                    premiumRange.getPremiums().add(premium);
                }
            }
        }
    }
    
    private void calculatePercentPremiumDifferences() {
        for (Premium premium : premiums) {
            premium.setPercentPremiumDifference(calculatePercentPremiumDiff(premium));
        }
    }
    
    private double calculatePercentPremiumDiff(final Premium premium) {
        int v1 = premium.getRatePlans().get(0).getPremium();
        int v2 = premium.getRatePlans().get(1).getPremium();
        return new BigDecimal(((v2 - v1) / v1) * 100).doubleValue();
    }
}

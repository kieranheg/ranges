package com.kieranheg;

import com.kieranheg.model.Premium;
import com.kieranheg.model.RatePlan;
import com.kieranheg.service.RatePlanReporter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class Ranger_UT {
    
    @Test
    @DisplayName("Initial range populating correctly")
    void givenPremiumsThenStoreInRange() {
        List<Premium> premiums = buildPremiums(10);
    
        RatePlanReporter ratePlanReporter = new RatePlanReporter(premiums);
        ratePlanReporter.buildPremiumReportRanges();
        
        assertThat(ratePlanReporter.getPremiums().size()).isEqualTo(9);
        assertThat(ratePlanReporter.getPremiums().get(0).getPercentPremiumDifference()).isEqualTo(100.00);
        assertThat(ratePlanReporter.getPremiums().get(8).getPercentPremiumDifference()).isEqualTo(1700.00);
    
        assertThat(ratePlanReporter.getPremiumRanges().get(0).getPremiums().size()).isEqualTo(0);
        assertThat(ratePlanReporter.getPremiumRanges().get(4).getPremiums().size()).isEqualTo(2);
    
    }
    
    
    private List<Premium> buildPremiums(int premiumListSize) {
        List<Premium> premiums = new ArrayList<>();
        for (int i = 1; i < premiumListSize; i++) {
            premiums.add(Premium.builder().id(i).ratePlans(buildRatePlan(i)).build());
        }
        return premiums;
    }
    
    private List<RatePlan> buildRatePlan(int premium) {
        return asList(
                RatePlan.builder().premium(premium).type("C").build(),
                RatePlan.builder().premium(premium * (premium * 2)).type("P").build());
    }
}

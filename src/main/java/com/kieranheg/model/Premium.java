package com.kieranheg.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Premium {
    final int id;
    final List<RatePlan> ratePlans;
    double percentPremiumDifference;
}

package com.kieranheg.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Range {
    private final int minRange;
    private final int maxRange;
    
    public boolean isInRange(double premium) {
        return (premium >= getMinRange() && premium < getMaxRange());
    }
}

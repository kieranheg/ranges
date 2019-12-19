package com.kieranheg.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class PremiumRange {
    private Range range;
    @Builder.Default
    private List<Premium> premiums = new ArrayList<>();
}

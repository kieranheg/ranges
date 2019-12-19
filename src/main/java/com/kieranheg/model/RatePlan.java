package com.kieranheg.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RatePlan {
    int premium;
    String type;
}

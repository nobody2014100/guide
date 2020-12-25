package com.klaus.iv.stockspider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuideRateFragmentDto {
    private String fragment;

    private BigDecimal rate;

    @Override
    public String toString() {
        return "GuideRateFragmentDto{" +
                "fragment='" + fragment + '\'' +
                ", rate=" + rate.setScale(2, BigDecimal.ROUND_UP) +
                '}';
    }
}

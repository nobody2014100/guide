package com.klaus.iv.stockspider.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {
    private Set<String> code = new HashSet<>();

}

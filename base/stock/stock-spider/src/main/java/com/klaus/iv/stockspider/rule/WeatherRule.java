package com.klaus.iv.stockspider.rule;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;


@Slf4j
@Rule(name = "weather rule", description = "if it rains then take an umbrella")
public class WeatherRule {

    @Condition
    public boolean itRains(@Fact("stockCode") String stockCode) {
        log.info("juge rule by stockCode: {}",stockCode);
        return true;
    }

    @Action
    public void takeAnUmbrella(@Fact("stockCode") String stockCode) {
        log.info("It rains, take an umbrella! {}", stockCode);
    }
}

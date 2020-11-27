package com.klaus.iv.appgateway.config;

import com.klaus.iv.appgateway.filter.CustomGlobalFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


/**
 * define some core configurations
 */
//@Component
public class Config {

//    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }

//    @Bean
    public GlobalFilter customFilter() {
        return new CustomGlobalFilter();
    }
}

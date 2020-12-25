package com.klaus.iv.stockspider.config;


import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class OkhttpConfig {

    @Value("${okhttp.connectTimeout:30}")
    private int connectTimeout;
    @Value("${okhttp.writeTimeout:60}")
    private int writeTimeout;
    @Value("${okhttp.readTimeout:60}")
    private int readTimeout;

    @Bean
    public OkHttpClient okHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                ;
        return builder.build();
    }



}

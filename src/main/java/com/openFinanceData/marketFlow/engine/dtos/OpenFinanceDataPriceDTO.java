package com.openFinanceData.marketFlow.engine.dtos;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenFinanceDataPriceDTO {
    
    private QuoteResponse quoteResponse;
    
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class QuoteResponse {
        private Result[] result;
    }
    
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        private String symbol;
        private BigDecimal regularMarketPrice;
        private BigDecimal regularMarketChange;
        private Date regularMarketTime;
        private String marketState;
        // private Price price;
    }

    // @Data
    // public static class Price {
    //     private String symbol;
    //     private BigDecimal regularMarketPrice;
    //     private BigDecimal regularMarketChange;
    //     private Date regularMarketTime;
    //     private String marketState;
    // }
}
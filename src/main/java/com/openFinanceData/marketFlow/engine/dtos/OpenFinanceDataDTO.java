package com.openFinanceData.marketFlow.engine.dtos;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class OpenFinanceDataDTO {

    @Data
    private class QuoteSummary {
        private Result[] result;
    }
    @Data
    private class Result {
        private Price price;
    }

    @Data
    private class Price {
        private String symbol;
        private BigDecimal regularMarketPrice;
        private BigDecimal regularMarketChange;
        private Date regularMarketTime;
        private String marketState;
    }

    
}

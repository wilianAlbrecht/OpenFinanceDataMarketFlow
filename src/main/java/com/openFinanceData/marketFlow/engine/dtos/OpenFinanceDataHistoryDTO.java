package com.openFinanceData.marketFlow.engine.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenFinanceDataHistoryDTO {

    private Chart chart;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Chart {
        private Result[] result;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        private Meta meta;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Meta {
        private String symbol;
        private Indicators indicators;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Indicators {
        private Quote[] quote;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Quote {
        private double[] close;
        private double[] high;
        private double[] low;
    }
}

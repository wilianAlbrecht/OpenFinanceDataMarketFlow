package com.openFinanceData.marketFlow.engine.datasourse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openFinanceData.marketFlow.engine.dtos.OpenFinanceDataDTO;
import com.openfinancedatalib.OpenFinanceData;

public class OpenFinanceDataSource {

    private final OpenFinanceData client;
    ObjectMapper mapper = new ObjectMapper();

    public OpenFinanceDataSource() {
        this.client = new OpenFinanceData();
    }

    public OpenFinanceDataDTO getMarketData(String symbol) {
        return mapper.convertValue(client.getQuote(symbol), OpenFinanceDataDTO.class);
    }

}

package com.openFinanceData.marketFlow.engine.datasourse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openFinanceData.marketFlow.engine.dtos.OpenFinanceDataHistoryDTO;
import com.openFinanceData.marketFlow.engine.dtos.OpenFinanceDataPriceDTO;
import com.openfinancedatalib.OpenFinanceData;

public class OpenFinanceDataSource {

    private static final OpenFinanceData client = new OpenFinanceData();
    ObjectMapper mapper = new ObjectMapper();

    public OpenFinanceDataSource() {
        // this.client = new OpenFinanceData();
    }

    public OpenFinanceDataPriceDTO getMarketData(String symbol) {
        return mapper.convertValue(client.getQuote(symbol), OpenFinanceDataPriceDTO.class);
    }

    public OpenFinanceDataHistoryDTO getHistory(String symbol) {
        return mapper.convertValue(client.getHistory(symbol, "1d", "1m"), OpenFinanceDataHistoryDTO.class);
    }

}

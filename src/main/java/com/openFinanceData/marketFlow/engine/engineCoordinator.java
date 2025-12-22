package com.openFinanceData.marketFlow.engine;

import com.openFinanceData.marketFlow.engine.datasourse.OpenFinanceDataSource;
import com.openFinanceData.marketFlow.engine.dtos.OpenFinanceDataDTO;

public class engineCoordinator {

    OpenFinanceDataSource dataSource = new OpenFinanceDataSource();

    public void priceCoordinator(String symbol) {
        
        OpenFinanceDataDTO dto = dataSource.getMarketData(symbol);
        
    }

}

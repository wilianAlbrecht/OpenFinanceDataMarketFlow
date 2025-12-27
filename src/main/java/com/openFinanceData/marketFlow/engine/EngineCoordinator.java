package com.openFinanceData.marketFlow.engine;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.openFinanceData.marketFlow.engine.cache.MarketAsset;
import com.openFinanceData.marketFlow.engine.cache.MarketPriceStore;
import com.openFinanceData.marketFlow.engine.cache.RealSnapshot;
import com.openFinanceData.marketFlow.engine.datasourse.OpenFinanceDataSource;
import com.openFinanceData.marketFlow.engine.dtos.OpenFinanceDataDTO;

@Service
public class EngineCoordinator {

    OpenFinanceDataSource openFinanceDataSource = new OpenFinanceDataSource();

    public RealSnapshot getPriceCoordinator(String symbol) {

        MarketAsset marketAsset = MarketPriceStore.get(symbol);

        if (marketAsset == null) {

            openFinanceDataSource = new OpenFinanceDataSource();
            OpenFinanceDataDTO dto = openFinanceDataSource.getMarketData(symbol);


            RealSnapshot snapshot = new RealSnapshot(
                    dto.getQuoteResponse().getResult()[0].getSymbol(),
                    null,
                    null,
                    null,
                    dto.getQuoteResponse().getResult()[0].getRegularMarketTime(),
                    new Date(),
                    dto.getQuoteResponse().getResult()[0].getMarketState());

            return snapshot;

        } else {
            return marketAsset.getRealSnapshot();
        }

    }

}

package com.openFinanceData.marketFlow.engine;

import org.springframework.stereotype.Service;

import com.openFinanceData.marketFlow.engine.cache.marketPrice.MarketAsset;
import com.openFinanceData.marketFlow.engine.cache.marketPrice.MarketPriceStore;
import com.openFinanceData.marketFlow.engine.cache.marketPrice.RealSnapshot;
import com.openFinanceData.marketFlow.engine.calculator.EnginePriceCalculator;
import com.openFinanceData.marketFlow.engine.calculator.EngineVariationPriceCalculator;
import com.openFinanceData.marketFlow.engine.datasourse.OpenFinanceDataSource;
import com.openFinanceData.marketFlow.engine.dtos.OpenFinanceDataHistoryDTO;
import com.openFinanceData.marketFlow.engine.dtos.OpenFinanceDataPriceDTO;

@Service
public class EngineCoordinator {

    OpenFinanceDataSource openFinanceDataSource = new OpenFinanceDataSource();
    EnginePriceCalculator engineCalculator = new EnginePriceCalculator();
    EngineVariationPriceCalculator engineAveragePriceCalculator = new EngineVariationPriceCalculator();

    public RealSnapshot getPriceCoordinator(String symbol) {

        MarketAsset marketAsset = MarketPriceStore.get(symbol);

        if (marketAsset == null) {

            openFinanceDataSource = new OpenFinanceDataSource();
            OpenFinanceDataPriceDTO priceDTO = openFinanceDataSource.getMarketData(symbol);
            OpenFinanceDataHistoryDTO historyDTO = openFinanceDataSource.getHistory(symbol);

            engineAveragePriceCalculator.calculateVariationPrice(historyDTO);
            

            RealSnapshot snapshot = engineCalculator.calculateRealSnapshot(priceDTO);
            return snapshot;

        } else {
            return marketAsset.getRealSnapshot();
        }

    }

}

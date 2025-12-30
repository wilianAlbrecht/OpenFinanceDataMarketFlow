package com.openFinanceData.marketFlow.engine.calculator;

import com.openFinanceData.marketFlow.engine.cache.averagePrice.VariationPriceAsset;
import com.openFinanceData.marketFlow.engine.cache.averagePrice.VariationPriceStore;
import com.openFinanceData.marketFlow.engine.cache.averagePrice.VariationSnapshot;
import com.openFinanceData.marketFlow.engine.dtos.OpenFinanceDataHistoryDTO;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class EngineVariationPriceCalculator {

    private BigDecimal closeVariation = BigDecimal.ZERO;
    private String symbol;

    public void calculateVariationPrice(OpenFinanceDataHistoryDTO historyDTO) {
        symbol = historyDTO.getChart().getResult()[0].getMeta().getSymbol();

        BigDecimal[] closeVariations = calculateCloseVariationPerMinute(
                historyDTO
                        .getChart()
                        .getResult()[0].getMeta()
                        .getIndicators()
                        .getQuote()[0].getClose());

        calculateTotalCloseVariation(closeVariations);

        VariationSnapshot averageSnapshot = new VariationSnapshot(
                closeVariation);

        VariationPriceAsset asset = VariationPriceStore.getOrCreate(symbol);
        asset.updateAverageSnapshot(averageSnapshot);
        VariationPriceStore.getOrCreate(symbol);
    }

    public BigDecimal[] calculateCloseVariationPerMinute(double[] close) {

        BigDecimal[] returns = new BigDecimal[close.length - 1];

        for (int i = 1; i < close.length; i++) {
            returns[i - 1] = BigDecimal.valueOf(close[i])
                    .subtract(BigDecimal.valueOf(close[i - 1]))
                    .divide(
                            BigDecimal.valueOf(close[i - 1]),
                            8,
                            RoundingMode.HALF_UP);
        }

        return returns;
    }

    public void calculateTotalCloseVariation(BigDecimal[] closeVariations) {

        BigDecimal sumAbs = BigDecimal.ZERO;

        for (BigDecimal value : closeVariations) {
            sumAbs = sumAbs.add(value.abs());
        }

        closeVariation = sumAbs.divide(
                BigDecimal.valueOf(closeVariations.length),
                8,
                RoundingMode.HALF_UP);
    }
}

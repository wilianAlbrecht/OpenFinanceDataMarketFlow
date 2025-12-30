package com.openFinanceData.marketFlow.engine.cache.averagePrice;

public class VariationPriceAsset {

    private final String symbol;
    private volatile VariationSnapshot averageSnapshot;

    public VariationPriceAsset(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public VariationSnapshot getAverageSnapshot() {
        return averageSnapshot;
    }

    public void updateAverageSnapshot(VariationSnapshot snapshot) {
        this.averageSnapshot = snapshot;
    }
}

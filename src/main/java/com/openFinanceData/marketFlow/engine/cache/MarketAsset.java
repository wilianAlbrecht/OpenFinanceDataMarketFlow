package com.openFinanceData.marketFlow.engine.cache;

public class MarketAsset {

    private final String symbol;
    private volatile RealSnapshot realSnapshot;

    public MarketAsset(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public RealSnapshot getRealSnapshot() {
        return realSnapshot;
    }

    public void updateRealSnapshot(RealSnapshot snapshot) {
        this.realSnapshot = snapshot;
    }
}

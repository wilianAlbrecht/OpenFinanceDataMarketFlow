package com.openFinanceData.marketFlow.engine.cache.marketPrice;

import java.util.concurrent.ConcurrentHashMap;

public final class MarketPriceStore {

    private final static ConcurrentHashMap<String, MarketAsset> marketPriceCache = new ConcurrentHashMap<>();

    public static MarketAsset get(String symbol) {
        return marketPriceCache.get(symbol);
    }
    
    public static MarketAsset getOrCreate(String symbol) {
        return marketPriceCache.computeIfAbsent(symbol, MarketAsset::new);
    }

    public static void remove(String symbol) {
        marketPriceCache.remove(symbol);
    }

    public static int size() {
        return marketPriceCache.size();
    }
}

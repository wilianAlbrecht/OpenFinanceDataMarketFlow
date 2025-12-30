package com.openFinanceData.marketFlow.engine.cache.averagePrice;

import java.util.concurrent.ConcurrentHashMap;

public class VariationPriceStore {

    private static final ConcurrentHashMap<
        String,
        VariationPriceAsset
    > averagePriceCache = new ConcurrentHashMap<>();

    public static VariationPriceAsset get(
        String symbol,
        ConcurrentHashMap<String, VariationPriceAsset> concurrentHashMap
    ) {
        return concurrentHashMap.computeIfAbsent(
            symbol,
            VariationPriceAsset::new
        );
    }

    public static VariationPriceAsset getOrCreate(String symbol) {
        return averagePriceCache.computeIfAbsent(
            symbol,
            VariationPriceAsset::new
        );
    }

    public static void remove(String symbol) {
        averagePriceCache.remove(symbol);
    }

    public static int size() {
        return averagePriceCache.size();
    }
}

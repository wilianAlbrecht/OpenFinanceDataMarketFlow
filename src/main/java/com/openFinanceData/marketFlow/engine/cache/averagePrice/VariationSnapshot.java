package com.openFinanceData.marketFlow.engine.cache.averagePrice;

import java.math.BigDecimal;

public record VariationSnapshot(
    // double avgMovePerMinute,
    BigDecimal stdDevPerMinute
) {}
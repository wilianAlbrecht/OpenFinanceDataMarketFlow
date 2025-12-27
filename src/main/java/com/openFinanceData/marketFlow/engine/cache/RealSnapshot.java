package com.openFinanceData.marketFlow.engine.cache;

import java.util.Date;

public record RealSnapshot(

    String symbol,
    String simulatedSnapshot,
    String subscribers,
    Date lastSimulatedRefresh,
    Date lastRealRefresh,
    Date lastAccess,
    String marketState

){}

package com.openFinanceData.marketFlow.engine;

import org.junit.jupiter.api.Test;

import com.openFinanceData.marketFlow.engine.cache.RealSnapshot;

public class EngineCoordinatorTest {

    @Test
    void shouldFetchAndPrintMarketPrice() {

        EngineCoordinator coordinator = new EngineCoordinator();

        String symbol = "AAPL";

        System.out.println("====================================");
        System.out.println("Requesting market price for: " + symbol);
        System.out.println("====================================");

        RealSnapshot snapshot = coordinator.getPriceCoordinator(symbol);

        System.out.println("=========== RESULT ===========");

        if (snapshot == null) {
            System.out.println("Snapshot is NULL");
        } else {
            System.out.println("Symbol: " + snapshot.symbol());
            System.out.println("Market State: " + snapshot.marketState());
            System.out.println("Last Access: " + snapshot.lastAccess());
            System.out.println("Simulated Snapshot: " + snapshot.simulatedSnapshot());
            System.out.println("Last Real Refresh: " + snapshot.lastRealRefresh());
            System.out.println("Last Simulated Refresh: " + snapshot.lastSimulatedRefresh());
            System.out.println("Subscribers: " + snapshot.subscribers());
        }

        System.out.println("==============================");
    }
}

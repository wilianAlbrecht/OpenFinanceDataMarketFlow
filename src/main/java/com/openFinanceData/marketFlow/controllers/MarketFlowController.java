package com.openFinanceData.marketFlow.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openFinanceData.marketFlow.engine.EngineCoordinator;
import com.openFinanceData.marketFlow.engine.cache.RealSnapshot;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MarketFlowController {

    private final EngineCoordinator engineCoordinator;

    @RequestMapping("/market-snapshot")
    public ResponseEntity<String> getMarketSnapshot(String symbol) {
        RealSnapshot snapshot = engineCoordinator.getPriceCoordinator(symbol);
        return ResponseEntity.ok(snapshot.toString());
    }

}

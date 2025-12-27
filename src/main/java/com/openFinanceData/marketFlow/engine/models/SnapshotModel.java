package com.openFinanceData.marketFlow.engine.models;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SnapshotModel {


   private String symbol;
   private String simulatedSnapshot;
   private String subscribers;
   private Date lastSimulatedRefresh;
   private Date lastRealRefresh;
   private Date lastAccess;
   private String marketState;
   private BigDecimal marketPrice;
   private BigDecimal priceChange;

}
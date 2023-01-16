package com.practice.demo.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public interface StrategyAssetPrice {
    
    String getStrategyId();
    
    ZonedDateTime getDate();
    
    BigDecimal getAsset();
    
    BigDecimal getSupply();
    
    BigDecimal getPrice();
    
    
}

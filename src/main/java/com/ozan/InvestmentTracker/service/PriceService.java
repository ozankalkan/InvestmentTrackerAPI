package com.ozan.InvestmentTracker.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PriceService {

    // Sahte fiyat verisi
    private static final Map<String, Double> PRICE_MAP = new HashMap<>();

    static {
        PRICE_MAP.put("Apple", 185.50);     // Apple
        PRICE_MAP.put("Google", 2750.75);   // Google
        PRICE_MAP.put("Avax", 3200.00);    // Avax
        PRICE_MAP.put("Bitcoin", 69000.0);     // Bitcoin
        PRICE_MAP.put("Ethereum", 3700.0);      // Ethereum
        PRICE_MAP.put("Tesla", 210.20);     // Tesla
        // İstediğin kadar ekleyebilirsin
    }

    public double getCurrentPrice(String assetName) {
        // Asset bulunamazsa default fiyat dön
        return PRICE_MAP.getOrDefault(assetName, 100.0);
    }
}

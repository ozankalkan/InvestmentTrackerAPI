package com.ozan.InvestmentTracker.controller;

import com.ozan.InvestmentTracker.dto.PortfolioSummaryDTO;
import com.ozan.InvestmentTracker.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getPortfolio(@PathVariable Long customerId) {
        try {
            PortfolioSummaryDTO summary = portfolioService.getCustomerPortfolio(customerId);
            if (summary == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(summary);
        } catch (Exception e) {
            e.printStackTrace();  // Konsola detaylı hata mesajı basar
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }

    @GetMapping("/test")
    public String test() {
        return "API çalışıyor!";
}
}

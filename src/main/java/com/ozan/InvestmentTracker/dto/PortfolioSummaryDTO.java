package com.ozan.InvestmentTracker.dto;

import java.math.BigDecimal;
import java.util.List;

public class PortfolioSummaryDTO {

    private BigDecimal totalValue;
    private BigDecimal totalProfitLoss;
    private List<InvestmentDetailDTO> investments;

    // Getters & Setters
    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal getTotalProfitLoss() {
        return totalProfitLoss;
    }

    public void setTotalProfitLoss(BigDecimal totalProfitLoss) {
        this.totalProfitLoss = totalProfitLoss;
    }

    public List<InvestmentDetailDTO> getInvestments() {
        return investments;
    }

    public void setInvestments(List<InvestmentDetailDTO> investments) {
        this.investments = investments;
    }
}

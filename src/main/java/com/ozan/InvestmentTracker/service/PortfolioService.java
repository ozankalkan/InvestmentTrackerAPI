package com.ozan.InvestmentTracker.service;

import com.ozan.InvestmentTracker.dto.InvestmentDetailDTO;
import com.ozan.InvestmentTracker.dto.PortfolioSummaryDTO;
import com.ozan.InvestmentTracker.model.Investment;
import com.ozan.InvestmentTracker.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    private InvestmentRepository investmentRepository;

    @Autowired
    private PriceService priceService; // Dinamik fiyatlar için ekledik

    public PortfolioSummaryDTO getCustomerPortfolio(Long customerId) {
        List<Investment> investments = investmentRepository.findByCustomerId(customerId);
        List<InvestmentDetailDTO> detailList = new ArrayList<>();

        BigDecimal totalValue = BigDecimal.ZERO;
        BigDecimal totalProfitLoss = BigDecimal.ZERO;

        for (Investment inv : investments) {
            InvestmentDetailDTO dto = new InvestmentDetailDTO();
            dto.setAssetName(inv.getAssetName());
            dto.setQuantity(inv.getQuantity());
            dto.setPurchasePrice(inv.getPurchasePrice());

            // Güncel fiyatı dinamik olarak al
            BigDecimal currentPrice = BigDecimal.valueOf(priceService.getCurrentPrice(inv.getAssetName()));
            dto.setCurrentPrice(currentPrice);

            // Kar/Zarar = (güncel - alış) * adet
            BigDecimal profitLoss = currentPrice
                    .subtract(inv.getPurchasePrice())
                    .multiply(inv.getQuantity());
            dto.setProfitLoss(profitLoss);

            totalValue = totalValue.add(currentPrice.multiply(inv.getQuantity()));
            totalProfitLoss = totalProfitLoss.add(profitLoss);

            detailList.add(dto);
        }

        PortfolioSummaryDTO summary = new PortfolioSummaryDTO();
        summary.setTotalValue(totalValue);
        summary.setTotalProfitLoss(totalProfitLoss);
        summary.setInvestments(detailList);

        return summary;
    }
}

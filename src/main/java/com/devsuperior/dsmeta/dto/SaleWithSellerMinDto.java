package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SaleWithSallerProjections;
import java.time.LocalDate;

public class SaleWithSellerMinDto {
    private Long id;
    private Double amount;
    private LocalDate date;
    private String sellerName;

    public SaleWithSellerMinDto() {
    }

    public SaleWithSellerMinDto(Long id, Double amount, LocalDate date, String sellerName) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.sellerName = sellerName;
    }

    public SaleWithSellerMinDto(SaleWithSallerProjections dto) {
        this.id = dto.getId();
        this.amount = dto.getAmount();
        this.date = dto.getDate();
        this.sellerName = dto.getName();
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSellerName() {
        return sellerName;
    }
}

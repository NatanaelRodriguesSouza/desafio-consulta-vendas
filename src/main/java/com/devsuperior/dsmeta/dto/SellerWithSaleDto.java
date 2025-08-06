package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SellerWithSaleProjections;

public class SellerWithSaleDto {
    private String name;
    private Double total;

    public SellerWithSaleDto() {
    }

    public SellerWithSaleDto(String name, Double total) {
        this.name = name;
        this.total = total;
    }
    public SellerWithSaleDto(SellerWithSaleProjections dto) {
        this.name = dto.getName();
        this.total = dto.getTotal();
    }

    public String getName() {
        return name;
    }

    public Double getTotal() {
        return total;
    }
}

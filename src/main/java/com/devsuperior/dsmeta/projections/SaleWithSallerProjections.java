package com.devsuperior.dsmeta.projections;

import com.devsuperior.dsmeta.dto.SellerDto;
import com.devsuperior.dsmeta.entities.Seller;

import java.time.LocalDate;

public interface SaleWithSallerProjections {
    Long getId();
    String getName();
    LocalDate getDate();
    Double getAmount();
}

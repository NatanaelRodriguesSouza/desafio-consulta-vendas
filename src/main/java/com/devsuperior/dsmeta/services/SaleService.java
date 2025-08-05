package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SaleWithSellerMinDto;
import com.devsuperior.dsmeta.projections.SaleWithSallerProjections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleWithSellerMinDto> findSaleWithSeller(String minDate, String maxDate, String name, Pageable pageable) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate result = today.minusYears(1L);
		LocalDate min = (minDate == null || minDate.isEmpty()) ? result : LocalDate.parse(minDate);
		LocalDate max = (maxDate == null || maxDate.isEmpty()) ? today : LocalDate.parse(maxDate);
		Page<SaleWithSallerProjections> result1 = repository.findSaleWithSaller(min,max,name,pageable);
		Page<SaleWithSellerMinDto> list = result1.map(x->new SaleWithSellerMinDto(x));
		return list;
	}
}

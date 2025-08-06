package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.projections.SaleWithSallerProjections;
import com.devsuperior.dsmeta.projections.SellerWithSaleProjections;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query(nativeQuery = true,
            value = "SELECT tb_sales.id, tb_sales.amount, tb_sales.date, tb_seller.name " +
                    "FROM tb_sales " +
                    "INNER JOIN tb_seller ON tb_sales.seller_id = tb_seller.id " +
                    "WHERE tb_sales.date BETWEEN :minDate AND :maxDate " +
                    "AND UPPER(tb_seller.name) LIKE UPPER(CONCAT('%', :name, '%'))",
            countQuery = "SELECT count(*) FROM tb_sales " +
                    "INNER JOIN tb_seller ON tb_sales.seller_id = tb_seller.id " +
                    "WHERE tb_sales.date BETWEEN :minDate AND :maxDate " +
                    "AND UPPER(tb_seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<SaleWithSallerProjections> findSaleWithSaller(LocalDate minDate, LocalDate maxDate, String name, Pageable pageable);
    @Query(nativeQuery = true,value = "SELECT tb_seller.name , SUM(tb_sales.amount) AS total " +
            "FROM tb_sales\n" +
            "INNER JOIN tb_seller ON tb_sales.seller_id = tb_seller.id \n" +
            "WHERE tb_sales.date BETWEEN :minDate AND :maxDate\n" +
            "GROUP BY tb_seller.name")
    Page<SellerWithSaleProjections> findSellerWithSale(LocalDate minDate, LocalDate maxDate,Pageable pageable);
}

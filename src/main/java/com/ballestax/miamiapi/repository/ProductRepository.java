package com.ballestax.miamiapi.repository;

import com.ballestax.miamiapi.dto.ProductDto;
import com.ballestax.miamiapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products p WHERE p.location=:locationId", nativeQuery = true)
    List<Product> findAllByLocation(@Param("locationId")long locationId);
}

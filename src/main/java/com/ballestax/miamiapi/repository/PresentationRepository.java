package com.ballestax.miamiapi.repository;


import com.ballestax.miamiapi.model.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresentationRepository extends JpaRepository<Presentation, Long> {

    @Query(value = "SELECT * FROM presentations p WHERE p.product_id=:productId", nativeQuery = true)
    List<Presentation> findPresentationsByProductId(@Param("productId") Long productId);

}

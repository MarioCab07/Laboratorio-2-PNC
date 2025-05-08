package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Gift;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@Transactional
public interface iGiftRepository extends iGenericRepository<Gift, UUID> {

     Gift findByName(String name);

    @Query("SELECT g FROM Gift g WHERE g.price > :minPrice ORDER BY g.price DESC")
    List<Gift> findGiftsMoreExpensiveThan(@Param("minPrice") double minPrice);

    @Query(value = "SELECT * FROM gift WHERE price < :maxPrice", nativeQuery = true)
    List<Gift> findGiftsCheaperThan(@Param("maxPrice") double maxPrice);

}

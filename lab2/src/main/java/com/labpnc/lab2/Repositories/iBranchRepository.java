
package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import java.util.UUID;

@Transactional
public interface iBranchRepository extends iGenericRepository<Branch, UUID> {

    List<Banch> findByLocation(String location);

    @Query("SELECT b FROM Building b WHERE LOWER(b.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Branch> findByKeywordInName(@Param("keyword") String keyword);

    @Query(value = "SELECT * FROM building ORDER BY location", nativeQuery = true)
    List<Branch> getBuildingsOrderedByLocation();
}

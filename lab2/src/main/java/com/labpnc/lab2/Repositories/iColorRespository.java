
package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import java.util.UUID;

@Transactional
    public interface iColorRepository extends iGenericRepository<Color, UUID> {

   Color findByName(String name);

    @Query("SELECT c FROM Color c WHERE c.name LIKE :prefix%")
    List<Color> findByPrefix(@Param("prefix") String prefix);

    @Query(value = "SELECT * FROM color WHERE name ILIKE '%verde%'", nativeQuery = true)
    List<Color> searchVerde();
}

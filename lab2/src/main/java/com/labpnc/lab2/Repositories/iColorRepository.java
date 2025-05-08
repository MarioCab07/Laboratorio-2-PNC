
package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Booking;
import com.labpnc.lab2.Domain.Entities.Color;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import java.util.UUID;

@Transactional
public interface iColorRepository extends iGenericRepository<Color, Integer> {

    Color findByName(String name);

    @Query("SELECT c, f FROM Color c JOIN c.floors f")
    List<Object[]> findAllColorsWithFloors();


    @Modifying
    @Query(value = """
    INSERT INTO color (id_color, name)
    VALUES (:id, :name)
    """, nativeQuery = true)
    void insertColor(@Param("id") UUID id, @Param("name") String name);

}


package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import java.util.UUID;

@Transactional
public interface iAgregateRepository extends iGenericRepository<Agregate, UUID> {

  Agregate findByName(String name);

    @Query("SELECT a.* FROM Agregate a WHERE a.description LIKE %:text%")
    List<Agregate> searchByDescription(@Param("text") String text);

    @Query(value = "SELECT * FROM agregate ORDER BY name ASC", nativeQuery = true)
    List<Agregate> findAllOrderedByName();
}

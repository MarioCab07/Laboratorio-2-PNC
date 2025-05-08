
package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Agregate;
import com.labpnc.lab2.Domain.Entities.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import java.util.UUID;

@Transactional
public interface iAgregateRepository extends iGenericRepository<Agregate, UUID> {

  Agregate findByName(String name);

  @Query("SELECT r.agregate FROM Room r WHERE r.idRoom = :idRoom")
  Agregate findAgregateByRoomId(@Param("idRoom") UUID idRoom);


  @Modifying
  @Transactional
  @Query(value = """
    INSERT INTO agregate (id_agregate, name, description)
    VALUES (:id, :name, :description)
    """, nativeQuery = true)
  void insertAgregate(
          @Param("id") UUID id,
          @Param("name") String name,
          @Param("description") String description
  );


}

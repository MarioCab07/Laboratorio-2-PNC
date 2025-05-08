
package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import java.util.UUID;

@Transactional
public interface RoomRepository extends iGenericRepository<Room, UUID> {


    List<Room> findByName(String name);

    @Query("SELECT r FROM Room r WHERE r.floor.idFloor = :floorId")
    List<Room> findByFloor(@Param("floorId") UUID floorId);

    @Query(value = "SELECT * FROM room WHERE description ILIKE '%balcón%'", nativeQuery = true)
    List<Room> findRoomsWithBalcony();
}

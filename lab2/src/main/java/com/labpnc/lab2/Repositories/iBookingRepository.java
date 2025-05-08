package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import java.util.UUID;

@Transactional
public interface iBookingRepository extends iGenericRepository<Booking, UUID> {

    List<Booking> findByUserIdUserAndActive(UUID userId, Boolean active);

    @Query("SELECT b FROM Booking b WHERE b.checkIn >= :startDate AND b.checkOut <= :endDate")
    List<Booking> findBookingsBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true , value = "SELECT * FROM booking WHERE id_room = :roomId ")
    List<Booking> getRecentBookingsByRoom(@Param("roomId") UUID roomId);

}

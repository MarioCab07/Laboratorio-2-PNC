
package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Booking;
import com.labpnc.lab2.Domain.Entities.Salon;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import java.util.UUID;

@Transactional
public interface iSalonRepository extends iGenericRepository<Salon, UUID> {

    List<Salon> findByCapacityGreaterThan(int minCapacity);

    @Query("SELECT e FROM Salon e WHERE e.branch.idBranch = :branchId")
    List<Salon> findByBuilding(@Param("branchId") UUID buildingId);

    @Query(value = "SELECT * FROM salon WHERE capacity >= :minCapacity", nativeQuery = true)
    List<Salon> findByCapacity(@Param("minCapacity") Integer minCapacity);

}
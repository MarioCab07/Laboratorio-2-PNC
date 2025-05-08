
package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import java.util.UUID;

@Transactional
public interface iSalonRepository extends iGenericRepository<Salon, UUID> {

    List<Salon> findByCapacityGreaterThan(int minCapacity);

    @Query("SELECT e FROM EventRoom e WHERE e.branch.idBranch = :branchId")
    List<Salon> findByBuilding(@Param("branchId") UUID buildingId);

    @Query(value = "SELECT * FROM salon WHERE ornaments ILIKE %:ornament%", nativeQuery = true)
    List<Salon> searchByOrnament(@Param("ornament") String ornament);
}
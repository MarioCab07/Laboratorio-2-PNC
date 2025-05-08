
package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Booking;
import com.labpnc.lab2.Domain.Entities.Floor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import java.util.UUID;

@Transactional
public interface iFloorRepository extends iGenericRepository<Floor, UUID> {

    List<Floor> findByLevel(int level);

    @Query("SELECT f FROM Floor f WHERE f.branch.idBranch = :branchId")
    List<Floor> findByBuilding(@Param("branchId") UUID buildingId);

    @Query(value = "SELECT * FROM floor WHERE id_color_button = :colorId", nativeQuery = true)
    List<Floor> findByColorNative(@Param("colorId") UUID colorId);
}

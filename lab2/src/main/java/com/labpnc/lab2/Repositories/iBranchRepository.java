
package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Booking;
import com.labpnc.lab2.Domain.Entities.Branch;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import java.util.UUID;

@Transactional
public interface iBranchRepository extends iGenericRepository<Branch, UUID> {

    List<Branch> findByLocation(String location);

    @Query("SELECT b, COUNT(f) FROM Branch b LEFT JOIN b.floors f GROUP BY b")
    List<Object[]> findFloorsByBranch();

    @Modifying
    @Query(value = """
    INSERT INTO branch (id_branch, name, location)
    VALUES (:id, :name, :location)
    """, nativeQuery = true)
    void insertBranch(@Param("id") UUID id, @Param("name") String name, @Param("location") String location);

}


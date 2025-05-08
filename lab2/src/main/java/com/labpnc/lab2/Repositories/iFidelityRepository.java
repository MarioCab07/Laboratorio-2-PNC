package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Fidelity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@Transactional
public interface iFidelityRepository {

    List<Fidelity> findByUserIdUser(UUID userId);

    @Query("SELECT f FROM Fidelity f WHERE f.employee.idEmployee = :employeeId AND f.date = :date")
    List<Fidelity> findByEmployeeAndDate(@Param("employeeId") UUID employeeId, @Param("date") String date);

    @Query(value = "SELECT * FROM fidelity WHERE points > :minPoints", nativeQuery = true)
    List<Fidelity> findHighPointFidelities(@Param("minPoints") int minPoints);

}

package com.labpnc.lab2.Repositories;


import com.labpnc.lab2.Domain.Entities.Rotation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@Transactional
public interface iRotationRepository extends iGenericRepository<Rotation, UUID> {

    List<Rotation> findByIsActiveTrue();

    @Query("SELECT r FROM Rotation r")
    List<Rotation> findAllRotations();

    @Query(value = "SELECT * FROM rotation WHERE schedule = :schedule", nativeQuery = true)
    List<Rotation> findByScheduleNative(@Param("schedule") String schedule);
}

package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.WorkOrder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@Transactional
public interface iWorkOrderRepository extends iGenericRepository<WorkOrder, String> {

    List<WorkOrder> findByUserIdUser(UUID userId);

    @Query("SELECT w FROM WorkOrder w WHERE w.room.idRoom = :roomId")
    List<WorkOrder> findByRoomId(@Param("roomId") UUID roomId);

    @Query(value = "SELECT * FROM work_order WHERE date = :targetDate", nativeQuery = true)
    List<WorkOrder> findByDate(@Param("targetDate") String date);


}

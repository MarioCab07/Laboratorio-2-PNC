
package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Room;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@Transactional
public interface iRoomRepository extends iGenericRepository<Room, UUID> {


    List<Room> findByName(String name);

    @Query("SELECT r FROM Room r WHERE r.floor.idFloor = :floorId")
    List<Room> findByFloor(@Param("floorId") UUID floorId);

    @Query(value = """
    SELECT r.*
    FROM room r
    JOIN floor f ON r.id_floor = f.id_floor
    JOIN branch b ON f.id_branch = b.id_branch
    WHERE b.id_branch = :idBranch AND f.id_floor = :idFloor
    """, nativeQuery = true)
    List<Room> findRoomsByBranchAndFloor(
            @Param("idBranch") UUID idBranch,
            @Param("idFloor") UUID idFloor
    );


}

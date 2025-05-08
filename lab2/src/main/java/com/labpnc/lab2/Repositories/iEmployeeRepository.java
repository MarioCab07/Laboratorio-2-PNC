package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.Employee;
import com.labpnc.lab2.Domain.Entities.WorkOrder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@Transactional
public interface iEmployeeRepository extends iGenericRepository<Employee, UUID> {

    List<Employee> findByDepartment(String department);

    @Query("SELECT e.* FROM Employee e WHERE branch.idBranch = :branchId AND e.isManager = true")
    List<Employee> findManagersByBranch(@Param("branchId") UUID branchId);

    @Query(value = """
        SELECT * 
        FROM employee 
        WHERE department = :departmentName
        """, nativeQuery = true)
    List<Employee> getEmployeesByDepartment(@Param("departmentName") String departmentName);


    @Transactional
    interface iWorkOrderRepository extends iGenericRepository<WorkOrder, String> {


    }
}

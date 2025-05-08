package com.labpnc.lab2.Repositories;


import com.labpnc.lab2.Domain.Entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@Transactional
public interface iUserRepository extends iGenericRepository<User, UUID> {

    User findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT u FROM User u WHERE u.role.name = :roleName")
    List<User> getUsersByRoleName(@Param("roleName") String roleName);

    @Query(nativeQuery = true, value = "INSERT INTO user_data (first_name, last_name, birth_date, email, password) VALUES (:firstName, :lastName, :birth_date, :email, :password)")
    User insertUser(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("birth_date") String birthDate, @Param("email") String email, @Param("password") String password);


}

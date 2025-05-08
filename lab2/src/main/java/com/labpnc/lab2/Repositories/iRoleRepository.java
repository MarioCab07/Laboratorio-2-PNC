package com.labpnc.lab2.Repositories;


import jakarta.transaction.Transactional;
import com.labpnc.lab2.Domain.Entities.Role;

import java.util.UUID;

@Transactional
public interface iRoleRepository extends iGenericRepository<Role, UUID> {


}

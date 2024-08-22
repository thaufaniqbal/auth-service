package com.banyuijio.auth.repository;

import com.banyuijio.auth.entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleUserRepository extends JpaRepository<RoleUser, UUID> {
    RoleUser findByRoleId(UUID roleFunctionId);

    boolean existsByRoleNameIgnoreCase (String roleName);
}

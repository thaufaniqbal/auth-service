package com.banyuijio.auth.repository;

import com.banyuijio.auth.entity.RoleFunction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleFunctionRepository extends JpaRepository<RoleFunction, UUID> {
    RoleFunction findByRoleFunctionId(UUID roleFunctionId);
}

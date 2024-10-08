package com.banyuijio.auth.repository;

import com.banyuijio.auth.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserGroupRepository extends JpaRepository<UserGroup, UUID> {
    UserGroup findByUserGroupId(UUID userGroupId);
    boolean existsByUserGroupNameIgnoreCase(String userGroupName);
    boolean existsByUserGroupId(UUID userGroupId);
}

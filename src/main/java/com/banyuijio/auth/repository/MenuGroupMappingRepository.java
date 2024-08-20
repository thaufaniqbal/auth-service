package com.banyuijio.auth.repository;

import com.banyuijio.auth.entity.MenuGroupMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MenuGroupMappingRepository extends JpaRepository<MenuGroupMapping, UUID> {

    List<MenuGroupMapping> findAllByUserGroupId(UUID userGroupId);

}

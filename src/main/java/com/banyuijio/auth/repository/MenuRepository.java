package com.banyuijio.auth.repository;

import com.banyuijio.auth.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MenuRepository extends JpaRepository<Menu, UUID> {
    Menu findByMenuIdAndParentId (UUID menuId, UUID parentId);
    List<Menu> findAllByParentId (UUID parentId);
}


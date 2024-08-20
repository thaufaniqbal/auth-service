package com.banyuijio.auth.service.menu;

import com.banyuijio.auth.dto.menu.MenuOutput;

import java.util.List;
import java.util.UUID;

public interface MenuService {
    List<MenuOutput> getMenuUserInternal (UUID userId);
}

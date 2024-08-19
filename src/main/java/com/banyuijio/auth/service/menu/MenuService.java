package com.banyuijio.auth.service.menu;

import com.banyuijio.auth.dto.menu.MenuOutput;

import java.util.UUID;

public interface MenuService {
    MenuOutput getMenuUserInternal (UUID userId);
}

package com.banyuijio.auth.service.menu.list;

import com.banyuijio.auth.dto.menu.list.MenuListOutput;

import java.util.List;

public interface MenuListService {
    List<MenuListOutput> getMenuList();
}

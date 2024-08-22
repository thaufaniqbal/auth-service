package com.banyuijio.auth.service.menu.group;

import com.banyuijio.auth.dto.menu.group.MenuGroupCreateInput;
import com.banyuijio.auth.entity.MenuGroupMapping;

public interface MenuGroupService {
    MenuGroupMapping createMenuGroup (MenuGroupCreateInput input);
    void createMenuGroup(MenuGroupMapping menuGroupMapping);
}

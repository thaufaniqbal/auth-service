package com.banyuijio.auth.service.menu.group;

import com.banyuijio.auth.dto.menu.group.MenuGroupCreateInput;
import com.banyuijio.auth.entity.MenuGroupMapping;

import java.util.List;
import java.util.UUID;

public interface MenuGroupService {
    List<MenuGroupMapping> buildMenuGroup(MenuGroupCreateInput input, UUID userGroupId, String loginId);
    Object build (MenuGroupCreateInput input, UUID userGroupId, String loginId);
    void buildMenuGroup(List<MenuGroupMapping> menuGroupMappings);
}

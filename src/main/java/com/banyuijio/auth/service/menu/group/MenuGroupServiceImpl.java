package com.banyuijio.auth.service.menu.group;

import com.banyuijio.auth.dto.menu.group.MenuGroupCreateInput;
import com.banyuijio.auth.entity.MenuGroupMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuGroupServiceImpl implements MenuGroupService {
    @Override
    public MenuGroupMapping createMenuGroup(MenuGroupCreateInput input) {
        return null;
    }

    @Override
    public void createMenuGroup(MenuGroupMapping menuGroupMapping) {

    }
}

package com.banyuijio.auth.service.menu.group;

import com.banyuijio.auth.dto.menu.group.MenuGroupCreateInput;
import com.banyuijio.auth.entity.MenuGroupMapping;
import com.banyuijio.auth.repository.MenuGroupMappingRepository;
import com.banyuijio.auth.service.user.validator.UserValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuGroupServiceImpl implements MenuGroupService {
    private final MenuGroupMappingRepository menuGroupMappingRepository;
    private final UserValidator userValidator;
    @Override
    public List<MenuGroupMapping> buildMenuGroup(MenuGroupCreateInput input, UUID userGroupId, String loginId) {
        deleteGroupMappings(userGroupId);
        userValidator.validateLogin(loginId);
        List<MenuGroupMapping> results = new ArrayList<>();
        for (UUID menuId : input.getMenuIds()){
            MenuGroupMapping result = new MenuGroupMapping();
            userValidator.validateUserGroupId(userGroupId);
            result.setMenuGroupMappingId(UUID.randomUUID());
            result.setUserGroupId(userGroupId);
            result.setMenuId(menuId);
            results.add(result);
        }
        return results;
    }

    @Override
    public Object build(MenuGroupCreateInput input, UUID userGroupId, String loginId) {
        List<MenuGroupMapping> menuGroupMappings = buildMenuGroup(input, userGroupId, loginId);
        buildMenuGroup(menuGroupMappings);
        return menuGroupMappings;
    }

    @Override
    @Transactional
    public void buildMenuGroup(List<MenuGroupMapping> menuGroupMappings) {
        menuGroupMappingRepository.saveAll(menuGroupMappings);
    }

    @Transactional
    private void deleteGroupMappings (UUID userGroupMappingId){
        userValidator.validateUserGroupId(userGroupMappingId);
        List<MenuGroupMapping> groupMappings = menuGroupMappingRepository.findAllByUserGroupId(userGroupMappingId);
        if (!groupMappings.isEmpty()){
            menuGroupMappingRepository.deleteAll(groupMappings);
        }
    }
}

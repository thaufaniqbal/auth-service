package com.banyuijio.auth.service.menu;

import com.banyuijio.auth.dto.menu.MenuOutput;
import com.banyuijio.auth.entity.*;
import com.banyuijio.auth.enums.BooleanStatus;
import com.banyuijio.auth.enums.CrudTypeCode;
import com.banyuijio.auth.repository.*;
import com.banyuijio.auth.service.user.validator.UserValidator;
import com.banyuijio.auth.util.GlobalValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private static final UUID ZERO_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");

    private final UserInternalRepository userInternalRepository;
    private final UserGroupRepository userGroupRepository;
    private final MenuRepository menuRepository;
    private final MenuGroupMappingRepository menuGroupMappingRepository;
    private final RoleUserRepository roleUserRepository;
    private final RoleFunctionRepository roleFunctionRepository;
    private final GlobalValidator validator;
    private final UserValidator userValidator;
    @Override
    public List<MenuOutput> getMenuUserInternal(UUID userId) {
        validator.validateRequestMandatory(userId, "userId");
        userValidator.validateUserInternalId(userId);
        UserInternal user = userInternalRepository.findByUserId(userId);
        UserGroup userGroup = userGroupRepository.findByUserGroupId(user.getUserGroupId());
        List<MenuGroupMapping> groupMappings = menuGroupMappingRepository.findAllByUserGroupId(userGroup.getUserGroupId());
        return build(userGroup, groupMappings);
    }
    private List<MenuOutput> build (UserGroup userGroup, List<MenuGroupMapping> groupMappings){
        RoleUser roleUser = roleUserRepository.findByRoleId(userGroup.getRoleUserId());
        RoleFunction roleFunction = roleFunctionRepository.findByRoleFunctionId(roleUser.getRoleFunctionId());

        boolean superUser = BooleanStatus.fromCode(roleFunction.getSuperUser()).getBooleanStatus();
        boolean read = BooleanStatus.fromCode(roleFunction.getRead()).getBooleanStatus();
        boolean create = BooleanStatus.fromCode(roleFunction.getCreate()).getBooleanStatus();
        boolean edit = BooleanStatus.fromCode(roleFunction.getRead()).getBooleanStatus();
        boolean delete = BooleanStatus.fromCode(roleFunction.getUpdate()).getBooleanStatus();

        List<MenuOutput> menuOutputs = build(groupMappings);

        setRoleFunctionForMenu(menuOutputs, superUser, read, create, edit, delete);

        return menuOutputs;
    }
    private List<MenuOutput> build(List<MenuGroupMapping> groupMappings){
        List<MenuOutput> result = new ArrayList<>();
        for (MenuGroupMapping groupMapping : groupMappings){
            Menu menu = menuRepository.findByMenuIdAndParentId(groupMapping.getMenuId(), ZERO_UUID);
            MenuOutput menuOutput = new MenuOutput();
            menuOutput.setParentMenuId(menu.getParentId());
            menuOutput.setParentTitle(menu.getTittle());
            menuOutput.setSeq(menu.getSeq());

            List<MenuOutput.Menu> menuList = setMenuList(menu);
            menuOutput.setMenuList(menuList);

            result.add(menuOutput);
        }
        return result;
    }
    private List<MenuOutput.Menu> setMenuList(Menu menu){
        List<MenuOutput.Menu> result = new ArrayList<>();
        List<Menu> menuFromParent = menuRepository.findAllByParentId(menu.getMenuId());
        if (!menuFromParent.isEmpty()){
            for (Menu menuForResult : menuFromParent){
                MenuOutput.Menu menuResult = build(menuForResult);
                result.add(menuResult);
            }
        }
        return result;
    }
    private MenuOutput.Menu build(Menu menu){
        MenuOutput.Menu result = new MenuOutput.Menu();
        result.setMenuId(menu.getMenuId());
        result.setMenuTitle(menu.getTittle());
        result.setLocation(menu.getLocation());
        result.setSeq(menu.getSeq());
        result.setCrudType(menu.getCrudType());
        return result;
    }
    private void setRoleFunctionForMenu (List<MenuOutput> menuOutputs,
                              boolean superUser,
                              boolean read,
                              boolean create,
                              boolean edit,
                              boolean delete){
        if (!superUser){
            setRead(menuOutputs, read);
            setCreate(menuOutputs, create);
            setEdit(menuOutputs, edit);
            setDelete(menuOutputs, delete);
        }
    }
    private void setRead(List<MenuOutput> menuOutputs, boolean read) {
        setCrudPermission(menuOutputs, read, CrudTypeCode.READ.getCode());
    }

    private void setCreate(List<MenuOutput> menuOutputs, boolean create) {
        setCrudPermission(menuOutputs, create, CrudTypeCode.CREATE.getCode());
    }

    private void setEdit(List<MenuOutput> menuOutputs, boolean edit) {
        setCrudPermission(menuOutputs, edit, CrudTypeCode.EDIT.getCode());
    }

    private void setDelete(List<MenuOutput> menuOutputs, boolean delete) {
        setCrudPermission(menuOutputs, delete, CrudTypeCode.DELETE.getCode());
    }
    private void setCrudPermission(List<MenuOutput> menuOutputs, boolean isEnabled, int crudType) {
        if (isEnabled) {
            for (MenuOutput menuOutput : menuOutputs) {
                removeMenuByRole(menuOutput.getMenuList(), crudType);
            }
        }
    }

    private void removeMenuByRole(List<MenuOutput.Menu> menuList, int crudType) {
        menuList.removeIf(menu -> menu.getCrudType() == crudType);
    }
}

package com.banyuijio.auth.service.user.group;

import com.banyuijio.auth.dto.user.group.UserGroupCreateInput;
import com.banyuijio.auth.entity.UserGroup;
import com.banyuijio.auth.repository.UserGroupRepository;
import com.banyuijio.auth.service.role.validator.RoleValidator;
import com.banyuijio.auth.service.user.validator.UserValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserGroupServiceImpl implements UserGroupService {
    private final UserGroupRepository userGroupRepository;

    private final UserValidator userValidator;
    private final RoleValidator roleValidator;
    @Override
    public UserGroup buildUserGroup(UserGroupCreateInput input, UUID userGroupId, String loginId) {
        userValidator.validateLogin(loginId);
        UserGroup result = new UserGroup();
        roleValidator.validateRoleId(input.getRoleUserId());
        if (Objects.nonNull(userGroupId)){
            result.setUserGroupId(userGroupId);
            if (!input.getUserGroupName().isEmpty()){
                userValidator.validateUserGroupName(input.getUserGroupName());
            }
        }else {
            result.setUserGroupId(UUID.randomUUID());
        }
        roleValidator.validateRoleAndUsersUpdate(input.getRoleUserId(), loginId);
        result.setUserGroupName(input.getUserGroupName());
        result.setRoleUserId(input.getRoleUserId());
        return result;
    }

    @Override
    public Object build(UserGroupCreateInput input, UUID userGroupId, String loginId) {
        UserGroup roleFunction = buildUserGroup(input, userGroupId, loginId);
        buildUserGroup(roleFunction);
        return roleFunction;
    }

    @Override
    @Transactional
    public void buildUserGroup(UserGroup userGroup) {
        userGroupRepository.save(userGroup);
    }
}

package com.banyuijio.auth.service.role.user;

import com.banyuijio.auth.dto.role.user.RoleUserCreateInput;
import com.banyuijio.auth.entity.RoleUser;

import java.util.UUID;

public interface RoleUserService {
    RoleUser createRoleUser(RoleUserCreateInput input, UUID roleId, String loginId);
    void createRoleUser(RoleUser roleUser);
}

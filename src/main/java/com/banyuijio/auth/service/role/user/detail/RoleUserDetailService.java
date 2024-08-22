package com.banyuijio.auth.service.role.user.detail;

import com.banyuijio.auth.dto.role.user.RoleUserDetailOutput;

import java.util.UUID;

public interface RoleUserDetailService {
    RoleUserDetailOutput getRoleUserDetail(UUID roleId);
}

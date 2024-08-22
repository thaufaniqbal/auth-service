package com.banyuijio.auth.service.role.user.list;

import com.banyuijio.auth.dto.role.user.RoleUserListOutput;

import java.util.List;

public interface RoleUserListService {
    List<RoleUserListOutput> getRoleUserList();
}

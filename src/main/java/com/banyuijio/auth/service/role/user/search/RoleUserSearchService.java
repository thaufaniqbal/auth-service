package com.banyuijio.auth.service.role.user.search;

import com.banyuijio.auth.dto.base.ResponsePageDTO;
import com.banyuijio.auth.dto.role.function.RoleFunctionSearchInput;

public interface RoleUserSearchService {
    ResponsePageDTO getRoleUserBySearch (RoleFunctionSearchInput input);
}

package com.banyuijio.auth.service.role.function;

import com.banyuijio.auth.dto.role.function.RoleFunctionCreateInput;
import com.banyuijio.auth.entity.RoleFunction;

import java.util.UUID;

public interface RoleFunctionService {
    RoleFunction buildRoleFunction(RoleFunctionCreateInput input, UUID roleFunctionId, String loginId);
    Object build(RoleFunctionCreateInput input, UUID roleFunctionId, String loginId);
    void buildRoleFunction(RoleFunction roleFunction);
}

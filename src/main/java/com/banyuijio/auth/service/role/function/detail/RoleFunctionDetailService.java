package com.banyuijio.auth.service.role.function.detail;

import com.banyuijio.auth.dto.role.function.RoleFunctionDetailOutput;

import java.util.UUID;

public interface RoleFunctionDetailService {
    RoleFunctionDetailOutput getRoleFunctionDetail (UUID roleFunctionId);
}

package com.banyuijio.auth.service.role.function.list;

import com.banyuijio.auth.dto.role.function.RoleFunctionListOutput;

import java.util.List;

public interface RoleFunctionListService {
    List<RoleFunctionListOutput> getRoleFunctionList();
}

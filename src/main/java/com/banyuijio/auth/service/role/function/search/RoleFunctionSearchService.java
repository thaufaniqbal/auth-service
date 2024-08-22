package com.banyuijio.auth.service.role.function.search;

import com.banyuijio.auth.dto.base.ResponsePageDTO;
import com.banyuijio.auth.dto.role.function.RoleFunctionSearchInput;

public interface RoleFunctionSearchService {
    ResponsePageDTO getRoleFunctionBySearch(RoleFunctionSearchInput input);
}

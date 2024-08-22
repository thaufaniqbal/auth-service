package com.banyuijio.auth.service.role.user.search;

import com.banyuijio.auth.dto.base.ResponsePageDTO;
import com.banyuijio.auth.dto.role.function.RoleFunctionSearchInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleUserSearchServiceImpl implements RoleUserSearchService {
    @Override
    public ResponsePageDTO getRoleUserBySearch(RoleFunctionSearchInput input) {
        return null;
    }
}

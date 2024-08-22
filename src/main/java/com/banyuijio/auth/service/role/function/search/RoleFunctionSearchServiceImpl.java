package com.banyuijio.auth.service.role.function.search;

import com.banyuijio.auth.dto.base.ResponsePageDTO;
import com.banyuijio.auth.dto.role.function.RoleFunctionSearchInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleFunctionSearchServiceImpl implements RoleFunctionSearchService {
    @Override
    public ResponsePageDTO getRoleFunctionBySearch(RoleFunctionSearchInput input) {
        return null;
    }
}

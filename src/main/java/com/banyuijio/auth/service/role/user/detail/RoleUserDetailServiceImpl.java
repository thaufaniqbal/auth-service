package com.banyuijio.auth.service.role.user.detail;

import com.banyuijio.auth.dto.role.user.RoleUserDetailOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class RoleUserDetailServiceImpl implements RoleUserDetailService {
    @Override
    public RoleUserDetailOutput getRoleUserDetail(UUID roleId) {
        return null;
    }
}

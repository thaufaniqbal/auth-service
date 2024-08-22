package com.banyuijio.auth.service.role.user.list;

import com.banyuijio.auth.dto.role.user.RoleUserListOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RoleUserListServiceImpl implements RoleUserListService {
    @Override
    public List<RoleUserListOutput> getRoleUserList() {
        return null;
    }
}

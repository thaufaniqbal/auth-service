package com.banyuijio.auth.service.user.group;

import com.banyuijio.auth.dto.user.group.UserGroupCreateInput;
import com.banyuijio.auth.entity.UserGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserGroupServiceImpl implements UserGroupService {
    @Override
    public UserGroup buildUserGroup(UserGroupCreateInput input) {
        return null;
    }

    @Override
    public void build(UserGroup userGroup) {

    }

    @Override
    public void buildUserGroup(UserGroup userGroup) {

    }
}

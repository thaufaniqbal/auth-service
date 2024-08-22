package com.banyuijio.auth.service.user.group;

import com.banyuijio.auth.dto.user.group.UserGroupCreateInput;
import com.banyuijio.auth.entity.UserGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserGroupServiceImpl implements UserGroupService {
    @Override
    public UserGroup createUserGroup(UserGroupCreateInput input) {
        return null;
    }

    @Override
    public void createUserGroup(UserGroup userGroup) {

    }
}

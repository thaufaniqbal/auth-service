package com.banyuijio.auth.service.user.group;

import com.banyuijio.auth.dto.user.group.UserGroupCreateInput;
import com.banyuijio.auth.entity.UserGroup;

public interface UserGroupService {
    UserGroup createUserGroup(UserGroupCreateInput input);
    void createUserGroup(UserGroup userGroup);
}

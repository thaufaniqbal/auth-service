package com.banyuijio.auth.service.user.group;

import com.banyuijio.auth.dto.user.group.UserGroupCreateInput;
import com.banyuijio.auth.entity.UserGroup;

import java.util.UUID;

public interface UserGroupService {
    UserGroup buildUserGroup(UserGroupCreateInput input, UUID userGroupId, String loginId);
    Object build (UserGroupCreateInput input, UUID userGroupId, String loginId);
    void buildUserGroup(UserGroup userGroup);
}

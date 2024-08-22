package com.banyuijio.auth.dto.user.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserGroupCreateInput {
    private String userGroupName;
    private UUID roleUserId;
}

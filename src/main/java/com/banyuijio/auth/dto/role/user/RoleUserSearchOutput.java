package com.banyuijio.auth.dto.role.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RoleUserSearchOutput {
    private UUID roleId;
    private String roleName;
    private String roleFunctionName;
}

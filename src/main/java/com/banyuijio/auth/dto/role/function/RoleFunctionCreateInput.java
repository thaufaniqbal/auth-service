package com.banyuijio.auth.dto.role.function;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RoleFunctionCreateInput {
    private String roleFunctionName;
    private int create;
    private int read;
    private int update;
    private int delete;
    private int superUser;
}

package com.banyuijio.auth.dto.role.function;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RoleFunctionDetailOutput {
    private UUID roleFunctionId;
    private String roleFunctionName;
    private int create;
    private int read;
    private int update;
    private int delete;
    private int superUser;
}

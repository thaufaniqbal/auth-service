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
public class RoleFunctionListOutput {
    private UUID roleFunctionId;
    private String roleFunctionName;
}

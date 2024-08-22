package com.banyuijio.auth.service.role.function;

import com.banyuijio.auth.dto.role.function.RoleFunctionCreateInput;
import com.banyuijio.auth.entity.RoleFunction;
import com.banyuijio.auth.enums.BooleanStatus;
import com.banyuijio.auth.repository.RoleFunctionRepository;
import com.banyuijio.auth.service.role.validate.RoleValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleFunctionServiceImpl implements RoleFunctionService {
    private final RoleFunctionRepository functionRepository;
    private final RoleValidator roleValidator;
    @Override
    public RoleFunction buildRoleFunction(RoleFunctionCreateInput input, UUID roleFunctionId, String loginId) {
        roleValidator.validate(input);
        RoleFunction result = new RoleFunction();
        if (Objects.nonNull(roleFunctionId)){
            result.setRoleFunctionId(roleFunctionId);
            if (!input.getRoleFunctionName().isEmpty()){
                roleValidator.validateFunctionName(input.getRoleFunctionName());
            }
        }else {
            result.setRoleFunctionId(UUID.randomUUID());
            roleValidator.validateFunctionName(input.getRoleFunctionName());
        }
        if (input.getSuperUser() == BooleanStatus.YES.getCode()){
            roleValidator.validateSuperUser(loginId);
        }
        result.setRoleFunctionName(input.getRoleFunctionName());
        result.setCreate(input.getCreate());
        result.setRead(input.getRead());
        result.setUpdate(input.getUpdate());
        result.setDelete(input.getDelete());
        result.setSuperUser(input.getSuperUser());
        return result;
    }

    @Override
    public Object build(RoleFunctionCreateInput input, UUID roleFunctionId, String loginId) {
        RoleFunction roleFunction = buildRoleFunction(input, roleFunctionId, loginId);
        buildRoleFunction(roleFunction);
        return roleFunction;
    }

    @Override
    @Transactional
    public void buildRoleFunction(RoleFunction roleFunction) {
        functionRepository.save(roleFunction);
    }
}

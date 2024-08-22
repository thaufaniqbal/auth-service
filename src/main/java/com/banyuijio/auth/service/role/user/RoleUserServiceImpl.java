package com.banyuijio.auth.service.role.user;

import com.banyuijio.auth.dto.role.user.RoleUserCreateInput;
import com.banyuijio.auth.entity.RoleUser;
import com.banyuijio.auth.repository.RoleUserRepository;
import com.banyuijio.auth.service.role.validate.RoleValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleUserServiceImpl implements RoleUserService {
    private final RoleUserRepository roleUserRepository;
    private final RoleValidator roleValidator;
    @Override
    public RoleUser buildRoleUser(RoleUserCreateInput input, UUID roleId, String loginId) {
        roleValidator.validate(input);
        roleValidator.validateFunctionAndUsersUpdate(input.getRoleFunctionId(), loginId);
        RoleUser result = new RoleUser();
        if (Objects.nonNull(roleId)){
            roleValidator.validateRoleId(roleId);
            result.setRoleId(roleId);
            if (!input.getRoleName().isEmpty()){
                roleValidator.validateRoleName(input.getRoleName());
            }
        }else {
            result.setRoleFunctionId(UUID.randomUUID());
            roleValidator.validateRoleName(input.getRoleName());
        }
        result.setRoleFunctionId(input.getRoleFunctionId());
        result.setRoleName(input.getRoleName());
        return result;
    }

    @Override
    public Object build(RoleUserCreateInput input, UUID roleId, String loginId) {
        RoleUser roleFunction = buildRoleUser(input, roleId, loginId);
        buildRoleUser(roleFunction);
        return roleFunction;
    }

    @Override
    @Transactional
    public void buildRoleUser(RoleUser roleUser) {
        roleUserRepository.save(roleUser);
    }
}

package com.banyuijio.auth.service.role.validate;

import com.banyuijio.auth.dto.role.function.RoleFunctionCreateInput;
import com.banyuijio.auth.dto.role.user.RoleUserCreateInput;
import com.banyuijio.auth.entity.RoleFunction;
import com.banyuijio.auth.entity.RoleUser;
import com.banyuijio.auth.entity.UserGroup;
import com.banyuijio.auth.entity.UserInternal;
import com.banyuijio.auth.enums.BooleanStatus;
import com.banyuijio.auth.enums.HttpStatusCode;
import com.banyuijio.auth.exception.HttpStatusException;
import com.banyuijio.auth.repository.RoleFunctionRepository;
import com.banyuijio.auth.repository.RoleUserRepository;
import com.banyuijio.auth.repository.UserGroupRepository;
import com.banyuijio.auth.repository.UserInternalRepository;
import com.banyuijio.auth.service.user.validator.UserValidator;
import com.banyuijio.auth.util.GlobalValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RoleValidator extends GlobalValidator {
    private final UserInternalRepository userInternalRepository;
    private final UserGroupRepository userGroupRepository;
    private final RoleFunctionRepository roleFunctionRepository;

    private final RoleFunctionRepository functionRepository;
    private final RoleUserRepository roleUserRepository;
    private final UserValidator userValidator;
    public void validate (RoleFunctionCreateInput input){
        validateRequestMandatory(input.getRoleFunctionName());
        validateRequestLength(input.getRoleFunctionName(), 5, 10);
        validateIntegerRequest(input.getCreate(), "create");
        validateIntegerRequest(input.getRead(), "read");
        validateIntegerRequest(input.getUpdate(), "update");
        validateIntegerRequest(input.getDelete(), "delete");
        validateIntegerRequest(input.getSuperUser(), "superUser");
    }

    public void validateFunctionName(String functionName){
        if (functionRepository.existsByRoleFunctionNameIgnoreCase(functionName)){
            throw new HttpStatusException(HttpStatusCode.DATA_ALREADY_EXIST, functionName);
        }
    }
    public void validate (RoleUserCreateInput input){
        validateRequestMandatory(input.getRoleName());
        validateRequestLength(input.getRoleName(), 5, 10);
        validateRequestMandatory(input.getRoleFunctionId(), "roleFunctionId");
        validateRoleFunctionId(input.getRoleFunctionId());
    }

    public void validateRoleFunctionId(UUID roleFunctionId){
        if (!functionRepository.existsById(roleFunctionId)){
            throw new HttpStatusException(HttpStatusCode.DATA_NOT_FOUND_FOR, "roleFunction");
        }
    }

    public void validateRoleName(String roleName){
        if (roleUserRepository.existsByRoleNameIgnoreCase(roleName)){
            throw new HttpStatusException(HttpStatusCode.DATA_ALREADY_EXIST, roleName);
        }
    }
    public void validateSuperUser(String loginId){
        userValidator.validateNotExistsUserName(loginId);
        UserInternal user = userInternalRepository.findByUsernameIgnoreCase(loginId);
        UserGroup userGroup = userGroupRepository.findByUserGroupId(user.getUserGroupId());
        RoleUser roleUser = roleUserRepository.findByRoleId(userGroup.getRoleUserId());
        RoleFunction roleFunction = roleFunctionRepository.findByRoleFunctionId(roleUser.getRoleFunctionId());
        if (roleFunction.getSuperUser()!= BooleanStatus.YES.getCode()){
            throw new HttpStatusException(HttpStatusCode.INVALID_USER, loginId);
        }
    }

    public void validateFunctionAndUsersUpdate(UUID roleFunctionId, String loginId){
        RoleFunction roleFunction = roleFunctionRepository.findByRoleFunctionId(roleFunctionId);
        if (roleFunction.getSuperUser() == BooleanStatus.YES.getCode()){
            validateSuperUser(loginId);
        }
    }
}

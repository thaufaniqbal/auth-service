package com.banyuijio.auth.service.user.validator;

import com.banyuijio.auth.enums.HttpStatusCode;
import com.banyuijio.auth.exception.HttpStatusException;
import com.banyuijio.auth.repository.UserGroupRepository;
import com.banyuijio.auth.repository.UserInternalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserValidator {
    private final UserGroupRepository userGroupRepository;
    private final UserInternalRepository userInternalRepository;

    public void validateUserInternalId(UUID userId){
        if (!userInternalRepository.existsById(userId)){
            throw new HttpStatusException(HttpStatusCode.UNAUTHORIZED);
        }
    }
    public void validateExistsUserName(String userName){
        if (userInternalRepository.existsByUsernameIgnoreCase(userName)){
            throw new HttpStatusException(HttpStatusCode.DATA_ALREADY_EXIST, "userName: "+ userName);
        }
    }
    public void validateNotExistsUserName(String userName){
        if (!userInternalRepository.existsByUsernameIgnoreCase(userName)){
            throw new HttpStatusException(HttpStatusCode.DATA_NOT_FOUND_FOR, "userName: "+ userName);
        }
    }
    public void validateLogin(String userName){
        if (!userInternalRepository.existsByUsernameIgnoreCase(userName)){
            throw new HttpStatusException(HttpStatusCode.UNAUTHORIZED);
        }
    }
    public void validateUserGroupName(String userGroupName){
        if (userGroupRepository.existsByUserGroupNameIgnoreCase(userGroupName)){
            throw new HttpStatusException(HttpStatusCode.DATA_ALREADY_EXIST, "userGroupName: "+ userGroupName);
        }
    }
    public void validateUserGroupId(UUID userGroupId){
        if (userGroupRepository.existsByUserGroupId(userGroupId)){
            throw new HttpStatusException(HttpStatusCode.DATA_NOT_FOUND_FOR, "userGroup: "+ userGroupId);
        }
    }
}

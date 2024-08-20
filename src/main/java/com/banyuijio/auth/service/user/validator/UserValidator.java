package com.banyuijio.auth.service.user.validator;

import com.banyuijio.auth.enums.HttpStatusCode;
import com.banyuijio.auth.exception.HttpStatusException;
import com.banyuijio.auth.repository.UserInternalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserValidator {
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
}

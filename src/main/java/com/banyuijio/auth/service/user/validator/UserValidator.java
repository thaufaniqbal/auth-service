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
}

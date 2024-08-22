package com.banyuijio.auth.service.auth;

import com.banyuijio.auth.dto.user.UserInternalLoginInput;
import com.banyuijio.auth.dto.user.UserInternalLoginOutput;
import com.banyuijio.auth.entity.UserInternal;
import com.banyuijio.auth.repository.UserInternalRepository;
import com.banyuijio.auth.service.user.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserInternalRepository userInternalRepository;
    private final UserValidator userValidator;
    @Override
    public UserInternalLoginOutput loginInternal(UserInternalLoginInput input) {
        UserInternalLoginOutput output = new UserInternalLoginOutput();
        userValidator.validateLogin(input.getUsername());
        UserInternal user = userInternalRepository.findByUsernameIgnoreCase(input.getUsername());
        if (user.getPassword().equalsIgnoreCase(input.getPassword())){
            output.setUserId(user.getUserId());
            output.setLoginId(user.getUsername());
        }
        return output;
    }
}

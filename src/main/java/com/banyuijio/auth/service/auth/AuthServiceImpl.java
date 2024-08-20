package com.banyuijio.auth.service.auth;

import com.banyuijio.auth.dto.user.UserInternalLoginInput;
import com.banyuijio.auth.dto.user.UserInternalLoginOutput;
import com.banyuijio.auth.entity.UserInternal;
import com.banyuijio.auth.enums.HttpStatusCode;
import com.banyuijio.auth.exception.HttpStatusException;
import com.banyuijio.auth.repository.UserInternalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserInternalRepository userInternalRepository;
    @Override
    public UserInternalLoginOutput loginInternal(UserInternalLoginInput input) {
        UserInternalLoginOutput output = new UserInternalLoginOutput();
        UserInternal user = userInternalRepository.findByUsername(input.getUsername())
                .orElseThrow(()->new HttpStatusException(HttpStatusCode.UNAUTHORIZED));
        if (user.getPassword().equalsIgnoreCase(input.getPassword())){
            output.setUserId(user.getUserId());
            output.setLoginId(user.getUsername());
        }
        return output;
    }
}

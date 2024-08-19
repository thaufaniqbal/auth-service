package com.banyuijio.auth.service.auth;

import com.banyuijio.auth.dto.user.UserInternalLoginInput;
import com.banyuijio.auth.dto.user.UserInternalLoginOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Override
    public UserInternalLoginOutput loginInternal(UserInternalLoginInput input) {
        return null;
    }
}

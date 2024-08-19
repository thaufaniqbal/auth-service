package com.banyuijio.auth.service.auth;

import com.banyuijio.auth.dto.user.UserInternalLoginInput;
import com.banyuijio.auth.dto.user.UserInternalLoginOutput;

public interface AuthService {
    UserInternalLoginOutput loginInternal (UserInternalLoginInput input);

}

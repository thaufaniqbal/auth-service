package com.banyuijio.auth.controller;

import com.banyuijio.auth.dto.base.ApiResponseDTO;
import com.banyuijio.auth.dto.user.UserInternalLoginInput;
import com.banyuijio.auth.service.auth.AuthService;
import com.banyuijio.auth.service.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    private final AuthService authService;
    private final MenuService menuService;
    @PostMapping("/login-internal")
    public ResponseEntity<ApiResponseDTO<Object>> loginInternal(@RequestBody UserInternalLoginInput input) {
        return ApiResponseDTO.toResponseEntity(HttpStatus.OK, authService.loginInternal(input));
    }
    @GetMapping("/menu-internal/{userId}")
    public ResponseEntity<ApiResponseDTO<Object>> getMenuUserInternal(@PathVariable UUID userId) {
        return ApiResponseDTO.toResponseEntity(HttpStatus.OK, menuService.getMenuUserInternal(userId));
    }

    @GetMapping("/hi")
    public ResponseEntity<ApiResponseDTO<Object>> hi() {
        return ApiResponseDTO.toResponseEntity(HttpStatus.OK, "hi, this is auth-service");
    }
}

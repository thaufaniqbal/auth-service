package com.banyuijio.auth.controller;

import com.banyuijio.auth.dto.base.ApiResponseDTO;
import com.banyuijio.auth.dto.role.function.RoleFunctionCreateInput;
import com.banyuijio.auth.dto.role.user.RoleUserCreateInput;
import com.banyuijio.auth.service.role.function.RoleFunctionService;
import com.banyuijio.auth.service.role.user.RoleUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/role")
public class RoleController {
    private final RoleFunctionService roleFunctionService;
    private final RoleUserService roleUserService;

    @PostMapping("/function")
    public ResponseEntity<ApiResponseDTO<Object>> createRoleFunction(@RequestBody RoleFunctionCreateInput input,
                                                                      @RequestHeader("login-id") String loginId) {
        return ApiResponseDTO.toResponseEntity(HttpStatus.CREATED, roleFunctionService.build(input, null, loginId));
    }
    @PutMapping("/function/{roleFunctionId}")
    public ResponseEntity<ApiResponseDTO<Object>> editRoleFunction(@RequestBody RoleFunctionCreateInput input,
                                                                   @RequestHeader("login-id") String loginId,
                                                                   @PathVariable UUID roleFunctionId) {
        return ApiResponseDTO.toResponseEntity(HttpStatus.ACCEPTED, roleFunctionService.build(input, roleFunctionId, loginId));
    }
    @PostMapping("/user")
    public ResponseEntity<ApiResponseDTO<Object>> createRoleUser(@RequestBody RoleUserCreateInput input,
                                                                     @RequestHeader("login-id") String loginId) {
        return ApiResponseDTO.toResponseEntity(HttpStatus.CREATED, roleUserService.build(input, null, loginId));
    }
    @PutMapping("/user/{roleId}")
    public ResponseEntity<ApiResponseDTO<Object>> editRoleRoleUser(@RequestBody RoleUserCreateInput input,
                                                                   @RequestHeader("login-id") String loginId,
                                                                   @PathVariable UUID roleId) {
        return ApiResponseDTO.toResponseEntity(HttpStatus.ACCEPTED, roleUserService.build(input, roleId, loginId));
    }

}

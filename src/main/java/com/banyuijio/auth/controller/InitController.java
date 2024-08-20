package com.banyuijio.auth.controller;

import com.banyuijio.auth.dto.base.ApiResponseDTO;
import com.banyuijio.auth.service.init.InitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/init")
public class InitController {
    private final InitService initService;

    @PostMapping("/login-internal")
    public ResponseEntity<ApiResponseDTO<Object>> loginInternal(@PathVariable String pass) {
        return ApiResponseDTO.toResponseEntity(HttpStatus.OK, initService.init(pass));
    }
}

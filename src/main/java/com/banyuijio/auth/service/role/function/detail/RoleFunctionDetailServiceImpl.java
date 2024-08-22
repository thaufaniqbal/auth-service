package com.banyuijio.auth.service.role.function.detail;

import com.banyuijio.auth.dto.role.function.RoleFunctionDetailOutput;
import com.banyuijio.auth.repository.RoleFunctionRepository;
import com.banyuijio.auth.service.role.validate.RoleValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class RoleFunctionDetailServiceImpl implements RoleFunctionDetailService {
    private final RoleFunctionRepository roleFunctionRepository;
    private final RoleValidator roleValidator;
    private final ObjectMapper objectMapper;
    @Override
    public RoleFunctionDetailOutput getRoleFunctionDetail(UUID roleFunctionId) {
        roleValidator.validateRoleFunctionId(roleFunctionId);
        return objectMapper.convertValue(
                roleFunctionRepository.findByRoleFunctionId(roleFunctionId),
                RoleFunctionDetailOutput.class);
    }
}

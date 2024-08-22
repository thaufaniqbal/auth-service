package com.banyuijio.auth.service.role.function.list;

import com.banyuijio.auth.dto.role.function.RoleFunctionListOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RoleFunctionListServiceImpl implements RoleFunctionListService {
    @Override
    public List<RoleFunctionListOutput> getRoleFunctionList() {
        return null;
    }
}

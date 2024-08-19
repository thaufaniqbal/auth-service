package com.banyuijio.auth.service.menu;

import com.banyuijio.auth.dto.menu.MenuOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    @Override
    public MenuOutput getMenuUserInternal(UUID userId) {
        return null;
    }
}

package com.banyuijio.auth.service.menu.list;

import com.banyuijio.auth.dto.menu.list.MenuListOutput;
import com.banyuijio.auth.entity.Menu;
import com.banyuijio.auth.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuListServiceImpl implements MenuListService {
    private static final UUID ZERO_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private final MenuRepository menuRepository;
    @Override
    public List<MenuListOutput> getMenuList() {
        List<Menu> menuFromParent = menuRepository.findAllByParentId(ZERO_UUID);
        return menuFromParent.stream().map(this::toDto).collect(Collectors.toList());
    }
    private MenuListOutput toDto (Menu menu){
        MenuListOutput result = new MenuListOutput();
        result.setMenuId(menu.getMenuId());
        result.setParentId(menu.getParentId());
        result.setMenuTitle(menu.getTittle());
        return result;
    }
}

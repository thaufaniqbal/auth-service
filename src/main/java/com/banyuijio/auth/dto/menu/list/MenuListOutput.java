package com.banyuijio.auth.dto.menu.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MenuListOutput {
    private UUID menuId;
    private UUID parentId;
    private String menuTitle;
}

package com.banyuijio.auth.dto.menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MenuOutput {
    private UUID parentMenuId;
    private String parentTitle;
    private int seq;
    private List<Menu> menuList;

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class Menu {
        private UUID menuId;
        private Integer seq;
        private String menuTitle;
        private String path;
        @JsonIgnore
        private int crudType;
    }
}

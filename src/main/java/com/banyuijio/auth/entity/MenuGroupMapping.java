package com.banyuijio.auth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "mst_menu_group")
public class MenuGroupMapping {
    @Id
    @Column(columnDefinition = "char(36)")
    private UUID menuGroupMappingId;
    @Column(columnDefinition = "char(36)")
    private UUID userGroupId;
    @Column(columnDefinition = "char(36)")
    private UUID menuId;
}

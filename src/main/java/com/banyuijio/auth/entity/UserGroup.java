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
@Table(name = "mst_user_group")
public class UserGroup {
    @Id
    @Column(columnDefinition = "char(36)")
    private UUID userGroupId;
    private String userGroupName;
    @Column(columnDefinition = "char(36)")
    private UUID roleUserId;
}

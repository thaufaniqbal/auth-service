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
@Table(name = "mst_user_internal")
public class UserInternal {
    @Id
    @Column(columnDefinition = "char(36)")
    private UUID userId;
    private String username;
    private String password;
    @Column(columnDefinition = "char(36)")
    private UUID userGroupId;
}

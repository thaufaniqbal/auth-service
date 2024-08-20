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
@Table(name = "mst_role_function")
public class RoleFunction {
    @Id
    @Column(columnDefinition = "char(36)")
    private UUID roleFunctionId;
    private String roleFunctionName;
    private int create;
    private int read;
    private int update;
    private int delete;
    private int superUser;
}

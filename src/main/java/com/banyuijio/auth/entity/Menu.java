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
@Table(name = "mst_menu")
public class Menu {
    @Id
    @Column(columnDefinition = "char(36)")
    private UUID menuId;
    @Column(columnDefinition = "char(36)")
    private UUID parentId;
    private int seq;
    private String tittle;
    private String location;
    private int crudType;
}

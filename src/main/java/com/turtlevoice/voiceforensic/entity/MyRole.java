package com.turtlevoice.voiceforensic.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

// class name 'Role' already exists in Spring
@Data
@Entity
@Table(name="roles")
public class MyRole {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false, unique=true)
    private String rolename;

    @ManyToMany(mappedBy="roles")
    private List<MyUser> users;

    public MyRole() {}

    public MyRole(String rolename) {
        this.rolename = rolename;
    }
}
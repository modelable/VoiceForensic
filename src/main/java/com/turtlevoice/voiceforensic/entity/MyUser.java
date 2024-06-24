package com.turtlevoice.voiceforensic.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

// class name 'User' already exists in Spring
@Data
@Entity
@Table(name="users")
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recordfiles_id")
    private RecordFile recordFile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "controlfiles_id")
    private ControlFile controlFile;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="user_role",
            joinColumns = {@JoinColumn(name="USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName = "ID")}
    )
    private List<MyRole> roles;
}
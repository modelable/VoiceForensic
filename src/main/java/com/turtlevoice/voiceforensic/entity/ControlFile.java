package com.turtlevoice.voiceforensic.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "controlfiles")
public class ControlFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private String path;
}
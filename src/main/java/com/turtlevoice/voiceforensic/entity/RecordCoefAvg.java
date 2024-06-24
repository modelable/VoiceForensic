package com.turtlevoice.voiceforensic.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recordcoefavgs")
public class RecordCoefAvg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double mfcc1;

//    @Column(nullable = false)
//    private Double mfcc2;

    @Column(nullable = false)
    private Double mfcc3;

    @Column(nullable = false)
    private Double mfcc4;

    @Column(nullable = false)
    private Double mfcc5;

    @Column(nullable = false)
    private Double mfcc6;

    @Column(nullable = false)
    private Double mfcc7;

    @Column(nullable = false)
    private Double mfcc8;

    @Column(nullable = false)
    private Double mfcc9;

    @Column(nullable = false)
    private Double mfcc10;

    @Column(nullable = false)
    private Double mfcc11;

    @Column(nullable = false)
    private Double mfcc12;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recordfiles_id")
    private RecordFile recordFile;
}
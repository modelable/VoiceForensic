package com.turtlevoice.voiceforensic.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double live_data_prediction;

    @Column(nullable = false)
    private Double record_data_prediction;

    @Column(nullable = false)
    private Double mae_similarity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recordfiles_id")
    private RecordFile recordFile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "controlfiles_id")
    private ControlFile controlFile;
}

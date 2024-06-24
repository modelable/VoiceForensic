package com.turtlevoice.voiceforensic;

import com.turtlevoice.voiceforensic.entity.*;
import com.turtlevoice.voiceforensic.repository.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class VoiceForensicApplicationTests {

    @Autowired
    private ControlCoefAvgRepository controlCoefAvgRepository;

    @Autowired
    private ControlCoefRepository controlCoefRepository;

    @Autowired
    private ControlFileRepository controlFileRepository;

    @Autowired
    private RecordCoefAvgRepository recordCoefAvgRepository;

    @Autowired
    private RecordCoefRepository recordCoefRepository;

    @Autowired
    private RecordFileRepository recordFileRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Test: generate tables")
    public void findProductById() {

        ControlCoef controlCoef = new ControlCoef();
        ControlCoefAvg controlCoefAvg = new ControlCoefAvg();
        ControlFile controlFile = new ControlFile();
        RecordCoef recordCoef = new RecordCoef();
        RecordCoefAvg recordCoefAvg = new RecordCoefAvg();
        RecordFile recordFile = new RecordFile();
        Result result = new Result();
    }
}

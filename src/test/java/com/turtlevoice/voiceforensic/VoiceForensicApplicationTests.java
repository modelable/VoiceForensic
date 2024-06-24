package com.turtlevoice.voiceforensic;

import com.turtlevoice.voiceforensic.entity.*;
import com.turtlevoice.voiceforensic.repository.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


        RecordFile recordFile = new RecordFile();
        recordFile.setFilename("test2.txt");
        recordFile.setPath("/test2");

        recordFileRepository.save(recordFile);

        RecordFile savedRecordFile = recordFileRepository.findById(recordFile.getId()).orElse(null);

        RecordCoef recordCoef = new RecordCoef();
        recordCoef.setMfcc1(1.1);
        recordCoef.setMfcc2(2.2);
        recordCoef.setMfcc3(3.3);
        recordCoef.setMfcc4(4.4);
        recordCoef.setMfcc5(5.5);
        recordCoef.setMfcc6(6.6);
        recordCoef.setMfcc7(7.7);
        recordCoef.setMfcc8(8.8);
        recordCoef.setMfcc9(9.9);
        recordCoef.setMfcc10(10.10);
        recordCoef.setMfcc11(11.11);
        recordCoef.setMfcc12(12.12);
        recordCoef.setRecordFile(savedRecordFile);

        RecordCoefAvg recordCoefAvg = new RecordCoefAvg();
        recordCoefAvg.setMfcc1(1.1);
        recordCoefAvg.setMfcc3(3.3);
        recordCoefAvg.setMfcc4(4.4);
        recordCoefAvg.setMfcc5(5.5);
        recordCoefAvg.setMfcc6(6.6);
        recordCoefAvg.setMfcc7(7.7);
        recordCoefAvg.setMfcc8(8.8);
        recordCoefAvg.setMfcc9(9.9);
        recordCoefAvg.setMfcc10(10.10);
        recordCoefAvg.setMfcc11(11.11);
        recordCoefAvg.setMfcc12(12.12);
        recordCoefAvg.setRecordFile(savedRecordFile);

        recordCoefRepository.save(recordCoef);
        recordCoefAvgRepository.save(recordCoefAvg);
        assertEquals(recordFile, savedRecordFile);
    }
}

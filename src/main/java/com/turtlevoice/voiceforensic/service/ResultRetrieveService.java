package com.turtlevoice.voiceforensic.service;

import com.turtlevoice.voiceforensic.pojo.UserAndResult;
import com.turtlevoice.voiceforensic.pojo.VisualizedResult;
import com.turtlevoice.voiceforensic.entity.Result;
import com.turtlevoice.voiceforensic.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultRetrieveService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private ControlCoefRepository controlCoefRepository;

    @Autowired
    private RecordCoefAvgRepository recordCoefAvgRepository;

    private Result checkUserResult(Integer userId){
        //너만의 로직을 뽐내봐
        //TODO: resultRepository 조회 후 result 반환
        //TODO: 오류핸들러를 통해 404, 500 등등 처리
        return new Result();
    }

    public UserAndResult getUserAndResult(Integer userId){
//        Result result = checkUserResult(userId);
//        RecordCoefAvg recordCoefAvg = recordCoefAvgRepository.getReferenceById()
//        ControlCoef controlCoef = controlCoefRepository.getReferenceById()
        return new UserAndResult();
    }

    public VisualizedResult getVisualizedResult(Integer userId){
//        Result result = checkUserResult(userId);
//        RecordCoefAvg recordCoefAvg = recordCoefAvgRepository.getReferenceById()
//        ControlCoef controlCoef = controlCoefRepository.getReferenceById()
        return new VisualizedResult();
    }
}

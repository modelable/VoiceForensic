package com.turtlevoice.voiceforensic.controller;

import com.turtlevoice.voiceforensic.pojo.UserAndResult;
import com.turtlevoice.voiceforensic.pojo.VisualizedResult;
import com.turtlevoice.voiceforensic.service.ResultRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    @Autowired
    private ResultRetrieveService resultRetrieveService;

    @GetMapping("/result")
    public UserAndResult getResult(@RequestParam Integer id) {
        return resultRetrieveService.getUserAndResult(id);
    }

    @GetMapping("/result_visual")
    public VisualizedResult getVisualizedResult(@RequestParam Integer id) {
        return resultRetrieveService.getVisualizedResult(id);
    }

    @GetMapping("/file_download")
    public void downloadFile(@RequestParam Integer id) {

    }

}

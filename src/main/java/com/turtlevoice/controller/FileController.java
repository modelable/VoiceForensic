package com.turtlevoice.controller;

import com.turtlevoice.service.ResultRetrieveService;
import com.turtlevoice.voiceforensic.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
    @Autowired
    private ResultRetrieveService resultRetrieveService;

    @GetMapping("/file_download")
    public void downloadFile(@RequestBody MyUser user){


    }
}

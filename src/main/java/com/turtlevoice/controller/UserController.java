package com.turtlevoice.controller;

import com.turtlevoice.voiceforensic.entity.MyUser;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/dashboard")
    public MyUser getUser(@RequestBody MyUser user){
        return user;
    }
}

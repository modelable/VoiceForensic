package com.turtlevoice.voiceforensic.controller;

import com.turtlevoice.voiceforensic.entity.MyRole;
import com.turtlevoice.voiceforensic.entity.MyUser;
import com.turtlevoice.voiceforensic.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private RegistrationService registrationService;


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("user") MyUser user, Model model) {

        if (registrationService.checkEmailExists(user.getEmail())) {
            model.addAttribute("emailExists", true);
            return "signup";
        }

        else {
            List<MyRole> userRoles = new ArrayList<>();

            MyRole role = registrationService.findByRolename("ROLE_USER");
            userRoles.add(role);

            // 특정 이메일 주소인 경우 ADMIN 역할 추가
            if ("admin@hansung.ac.kr".equals(user.getEmail())) {
                MyRole roleAdmin = registrationService.findByRolename("ROLE_ADMIN");
                userRoles.add(roleAdmin);
            }

            registrationService.createUser(user, userRoles);

            return "redirect:/";
        }
    }

}

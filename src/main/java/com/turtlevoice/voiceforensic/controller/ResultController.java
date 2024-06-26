package com.turtlevoice.voiceforensic.controller;

import com.turtlevoice.voiceforensic.entity.MyUser;
import com.turtlevoice.voiceforensic.repository.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller // 일단 REST 없이 구현 - return하는게 객체가 아니라 view name이라서
public class ResultController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/result")
    public String viewResultPage(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Optional<MyUser> currentUser = userRepository.findByUsername(userDetails.getUsername());

        if (currentUser.isPresent()) {
            MyUser user = currentUser.get();
            if (user.getControlFile() == null && user.getRecordFile() == null) {
                return "redirect:/no_result";
            } else {
                return "result";
            }
        }
        return "403";
    }

    @GetMapping("/result_visual")
    public String getVisualizedResult(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Optional<MyUser> currentUser = userRepository.findByUsername(userDetails.getUsername());

        if (currentUser.isPresent()) {
            MyUser user = currentUser.get();
            if (user.getControlFile() == null && user.getRecordFile() == null) {
                return "redirect:/no_result";
            } else {
                return "result_visual";
            }
        }
        return "403";
    }

    @GetMapping("/file_download")
    public void downloadFile(@RequestParam Integer id) {
        //TODO: file download 구현
    }

}

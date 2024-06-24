package com.turtlevoice.controller;


import com.turtlevoice.service.FlaskService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class SseController {
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    @Autowired
    private FlaskService flaskService;

    @GetMapping("/upload_wait_events")
    public SseEmitter handleUploadWaitEvents(HttpServletResponse response) {
        response.setContentType(MediaType.TEXT_EVENT_STREAM_VALUE);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Connection", "keep-alive");

        try {
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SseEmitter emitter = new SseEmitter();

        executorService.execute(() -> {
            try {
                String flaskUrl = "https://2903-223-194-159-214.ngrok-free.app";
                String[] engSteps = {"import_dataset", "mfcc_bar_graph", "mfcc_spectrum", "fft_spectrum", "label_setting", "training", "model_predict"};
                String[] korSteps = {"음성 추출 데이터셋 불러오기", "음성 특징 평균값 시각화", "MFCC 스펙트럼 시각화", "주파수 스펙트럼 시각화", "클러스트링(데이터 분류)", "AI 모델 학습", "유사도 측정"};
                RestTemplate restTemplate = new RestTemplate();

                for (int i = 0; i < engSteps.length; i++) {
                    flaskService.get(engSteps[i]);
                    emitter.send(SseEmitter.event()
                            .name("message")
                            .data(korSteps[i], MediaType.TEXT_PLAIN));
                }

                // 모든 단계가 완료되면 연결 종료를 알리는 이벤트를 보냅니다.
                emitter.send(SseEmitter.event()
                        .name("message")
                        .data("done", MediaType.TEXT_PLAIN));
                emitter.complete();
            } catch (IOException ex) {
                emitter.completeWithError(ex);
            }
        });

        return emitter;
    }
}
package com.chaorda.matchuum.controller;

import com.chaorda.matchuum.Message;
import com.chaorda.matchuum.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RequestController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/send")
    public String send(@RequestBody String message){

        // 1. 카프카로 메시지 보내는 코드
        kafkaTemplate.send("chaordakafka", message);

        return "ok";
    }
}

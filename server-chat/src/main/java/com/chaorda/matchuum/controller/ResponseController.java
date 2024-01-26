package com.chaorda.matchuum.controller;

import com.chaorda.matchuum.Message;
import com.chaorda.matchuum.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ResponseController {
    private final MessageRepository messageRepository;
    private final SimpMessageSendingOperations sendingOperations;


    // 2. 카프카로 메시지 받는 코드
    @KafkaListener(topics = "chaordakafka", groupId = "group-kafka")
    public void consume(String message) {
        sendingOperations.convertAndSend("/sub/1", message);

        // 4. 메시지를 저장하는 코드
        Message result = Message.builder()
                .name("서버A에서 온 메시지")
                .message(message)
                .build();
        messageRepository.save(result);
    }





}

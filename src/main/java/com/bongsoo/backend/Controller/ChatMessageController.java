package com.bongsoo.backend.Controller;


import com.bongsoo.backend.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class ChatMessageController {

    private final SimpMessageSendingOperations simpMessageSendingOperations;
    //메시지를 도착지까지 보내는 MessageSendingOperations<Destination> 을 스프링 프레임워크에 맞춘것. 문서에 대놓고 STOMP같은걸 지원하기 위함이라고 써져있다.
    private final MessageService messageService;


    @MessageMapping("/chat/message")            // Member 입장
    // 1. 프론트에서 받을 데이터 Vue 구조와 백에서 class 와 같은 형태의 구조 개발 필요
    public void enter(){//(Message message){
//        if(Status.ENTER.equals(message.getType())){
//            message.setMessage(message.getSender()+"님 입장");
//        }
//        simpMessageSendingOperations.convertAndSend("/topic/chat/room/"+message.getRoomId(),message);
        //convertAndSend 사용하여 STOMP 토픽으로 보낼 때 또는 핸들러 메소드의 결과로서 그 토픽을 구독하는 클라이언트는 메시지를 수신한다.
    }

    @MessageMapping("/chat/Message")        // message 받았을 때 처리 과정
    public void sendMessage(){ //(@Payload Message message){    // 이전 message class 모양으로 받아옴
//        message.setSendDate(LocalDateTime.now());             // 메세지 받은 시간을 기준으로 표기
//        message.setRoomId(message.getRoomId());               // 나니 고래? 왜 자신의 ID를 다시 자신의 ID로 표시???
//        simpMessageSendingOperations.convertAndSend("/topic/chat/room/"+message.getRoomId(),message);     // 모든 소켓에 메세지 뿌리기
//        messageService.appendToChatLogFile(message.getRoomId(),message);      // 채팅기록 txt 파일에 기록하기 위한 메소드 message 객체 넘겨주기
    }

}

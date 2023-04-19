package com.bongsoo.backend.Controller;


import com.bongsoo.backend.dto.MessageDTO;
import com.bongsoo.backend.service.MessageService;
import com.bongsoo.backend.type.MessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class RoomChatController {

    private final SimpMessageSendingOperations simpMessageSendingOperations;
    //메시지를 도착지까지 보내는 MessageSendingOperations<Destination> 을 스프링 프레임워크에 맞춘것. 문서에 대놓고 STOMP같은걸 지원하기 위함이라고 써져있다.
    private final MessageService messageService;


    @MessageMapping("/chat/message")            // Member 입장
    // 1. 프론트에서 받을 데이터 Vue 구조와 백에서 class 와 같은 형태의 구조 개발 필요
    public void enter(MessageDTO messageDTO){
        if(MessageType.ENTER.equals(messageDTO.getMessage_type()))
            messageDTO.setContent(messageDTO.getUser_id()+"님 입장");
        messageDTO.setDateTime(LocalDateTime.now());
        simpMessageSendingOperations.convertAndSend("/topic/chat/room/"+messageDTO.getUser_id(),messageDTO);
//        convertAndSend 사용하여 STOMP 토픽으로 보낼 때 또는 핸들러 메소드의 결과로서 그 토픽을 구독하는 클라이언트는 메시지를 수신한다.
    }

    @MessageMapping("/chat/Message")        // message 받았을 때 처리 과정
    public void sendMessage(MessageDTO messageDTO){    // 이전 message class 모양으로 받아옴
        messageDTO.setDateTime(LocalDateTime.now());             // 메세지 받은 시간을 기준으로 표기
        simpMessageSendingOperations.convertAndSend("/topic/chat/room/"+messageDTO.getRoom_id(),messageDTO);     // 모든 소켓에 메세지 뿌리기
        messageService.appendToChatLogFile(messageDTO.getRoom_id(),messageDTO);      // 서버 id 및 룸 id 필요 프론트에서 받아올 수 있으면 받고 없으면 JPA 돌려야하는데 채팅 보낼 때 마다 하기에는 부담이 크다
    }

}

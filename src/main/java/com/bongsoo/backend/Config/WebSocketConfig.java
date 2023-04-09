package com.bongsoo.backend.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/ws/chat").setAllowedOriginPatterns("*").withSockJS();
        //연결할 소켓 엔드포인트를 지정하는 코드이다.
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        registry.enableSimpleBroker("/topic","/queue");
        /**
         * 메세지브로커를 등록하는 코드
         * /topic은 한명이 message를 발행했을 때 해당 토픽을 구독하고 있는 n명에게 메세지를 뿌려야 하는 경우 사용한다.
         * /queue는 한명이 message를 발행했을 때 발행한 한명에게 다시 정보를 보내는 경우에 사용한다.
         */
        registry.setApplicationDestinationPrefixes("/app");
        /**
         * 도착경로에 대한 prfix를 설정
         * ex) /topic/hello 라는 토픽에 대해 구독을 신청했을 때 실제 경로를 /app/topic/hello가 된다.
         */
    }
}

package net.madvirus.spring4.chap09.jgkim;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WsConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(echoHandler(), "/echoHandlerSocket").withSockJS();
        registry.addHandler(chatSocketHandler(), "/chatSocketHandle").withSockJS();
    }

    @Bean
    public EchoHandler echoHandler(){
        return new EchoHandler();
    }

    @Bean
    public ChatSocketHandler chatSocketHandler(){
        return new ChatSocketHandler();
    }
}
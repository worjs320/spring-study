package net.madvirus.spring4.chap09.jgkim;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.printf("%s connect \n", session.getId());
    }

    @Override
    protected void handleTextMessage( WebSocketSession session, TextMessage message) throws Exception {
        System.out.printf("%s로부터 [%s] 받음\n", session.getId(), message.getPayload());
        session.sendMessage(new TextMessage("echo: " + message.getPayload()));
    }

    @Override
    public void afterConnectionClosed( WebSocketSession session, CloseStatus status) throws Exception {
        System.out.printf("%s disconnect\n", session.getId());
    }

}

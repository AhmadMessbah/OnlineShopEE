package com.mftplus.demo.controller.websocket;

import com.mftplus.demo.model.entity.Message;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.interceptor.InterceptorBinding;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
@Slf4j
@ServerEndpoint(
        value = "/messages.do",
        encoders = MessageEncoder.class,
        decoders = MessageDecoder.class,
        configurator = WebSocketConfigurator.class)
public class MessageEndpoint {

    public static Map<HttpSession, Session> allSessions = new HashMap<>();
    private static final Set<Session> sessions = new CopyOnWriteArraySet<>();

    @OnOpen
    @Loggable
    public void onOpen(Session session, EndpointConfig config) {
        sessions.add(session);
        allSessions.put(((HttpSession) session.getUserProperties().get(HttpSession.class.getName())), session);
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        session.getUserProperties().put(HttpSession.class.getName(), httpSession);
//        log.info("connection onOpen");
    }

    @OnMessage
    @Loggable
    public void onMessage(Session session, Message message) {
        System.out.println(((HttpSession) session.getUserProperties().get(HttpSession.class.getName())).getId());
        broadcast(message);
    }

    @OnClose
    @Loggable
    public void onClose(Session session) {
//        log.info("connection onClose");
        sessions.remove(session);
    }

    @OnError
    @Loggable
    public void onError(Session session, Throwable throwable) {
        sessions.remove(session);
        log.error(throwable.getMessage());
    }
    @Loggable
    public static void broadcast(Message message) {
        for (Session session : sessions) {
            if (session.isOpen()) {
                session.getAsyncRemote().sendObject(message);
            }
        }
    }
    @Loggable
    public static void send(Session session, Message message) {
        if (session.isOpen()) {
            session.getAsyncRemote().sendObject(message);
        }
    }
}

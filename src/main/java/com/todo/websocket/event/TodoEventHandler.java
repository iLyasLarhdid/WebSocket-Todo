package com.todo.websocket.event;

import com.todo.websocket.entities.TodoEntity;
import com.todo.websocket.properties.TodoProperties;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
@RepositoryEventHandler()
public class TodoEventHandler {
    private Logger log = LoggerFactory.getLogger(TodoEventHandler.class);
    private SimpMessagingTemplate simpMessagingTemplate;
    private TodoProperties todoProperties;
    public TodoEventHandler(SimpMessagingTemplate simpMessagingTemplate,TodoProperties todoProperties){
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.todoProperties=todoProperties;
    }


    @HandleAfterCreate
    public void handleTodoSave(TodoEntity todo){
        this.simpMessagingTemplate.convertAndSend(this.todoProperties.getBroker()+"/new",todo);
        log.info(">> Sending message to Ws : ws://todo/new - "+todo);
    }
}

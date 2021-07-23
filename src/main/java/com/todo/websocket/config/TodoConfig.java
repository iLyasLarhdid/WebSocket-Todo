package com.todo.websocket.config;

import com.todo.websocket.properties.TodoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@EnableConfigurationProperties(TodoProperties.class)
public class TodoConfig implements WebSocketMessageBrokerConfigurer {
    private TodoProperties properties;

    public TodoConfig(TodoProperties properties){
        this.properties = properties;
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(properties.getEndpoint()).setAllowedOrigins("/**").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(properties.getBroker());
        registry.setApplicationDestinationPrefixes(properties.getApp());
    }
}

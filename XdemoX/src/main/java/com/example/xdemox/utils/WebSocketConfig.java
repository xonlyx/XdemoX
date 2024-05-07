package com.example.xdemox.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter endpointExporter(){
        return new ServerEndpointExporter();
    }
}

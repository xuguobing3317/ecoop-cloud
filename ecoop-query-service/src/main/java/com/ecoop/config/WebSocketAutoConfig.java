package com.ecoop.config;

import com.ecoop.handler.WebSocketHandler;
import com.ecoop.interceptor.WebSocketInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @ClassName WebSocketAutoConfig
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-02 13:58
 * @Version 1.0
 **/
@Configuration
@EnableWebSocket
public class WebSocketAutoConfig implements WebSocketConfigurer {

    @Autowired
    private WebSocketHandler webSocketHandler;

    @Autowired
    private WebSocketInterceptor webSocketInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // webSocket通道
        // 指定处理器和路径
        registry.addHandler(webSocketHandler, "/websocket")
                // 指定自定义拦截器
                .addInterceptors(webSocketInterceptor)
                // 允许跨域
                .setAllowedOrigins("*");
        // sockJs通道
        registry.addHandler(webSocketHandler, "/sock-js")
                .addInterceptors(webSocketInterceptor)
                .setAllowedOrigins("*")
                // 开启sockJs支持
                .withSockJS();
    }
}

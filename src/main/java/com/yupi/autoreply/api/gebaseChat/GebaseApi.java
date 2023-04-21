package com.yupi.autoreply.api.gebaseChat;


import com.yupi.autoreply.api.gebaseChat.model.Message;
import com.yupi.autoreply.api.gebaseChat.model.SocketClient;
import org.java_websocket.client.WebSocketClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GebaseApi {
    @Resource
    private SocketClient socketClient;


    public WebSocketClient createSocketChat(String url){
        return socketClient.getClient(url);
    }
}

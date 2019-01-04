package com.dmd.parking_iot.attendant;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

@ClientEndpoint
public class ParkingIoTClient {

    private Session session;
    private ParkingIoTClientMessageHandler messageHandler;

    public ParkingIoTClient(ParkingIoTClientMessageHandler messageHandler) {
        this.messageHandler = messageHandler;
        WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
        String url = System.getenv().get("Parking_IoT_Server_URL");
        try {
            webSocketContainer.connectToServer(this, new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    @OnMessage
    public void onMessage(String message) {
        messageHandler.handleMessage(message);
    }

    @OnError
    public void onError() {
        System.out.println("something broke here");
    }
}

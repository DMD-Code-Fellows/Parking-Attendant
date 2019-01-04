package com.dmd.parking_iot.attendant;

import javax.websocket.MessageHandler;

public class ParkingIoTClientMessageHandler implements MessageHandler {

    public void handleMessage(String message) {
        System.out.println(message);
    }
}

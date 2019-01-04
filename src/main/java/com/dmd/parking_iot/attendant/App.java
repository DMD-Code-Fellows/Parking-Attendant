package com.dmd.parking_iot.attendant;

import java.io.IOException;

public class App {

    public static void main(String[] args) {
        ParkingIoTClient parkingIoTClient = new ParkingIoTClient(new ParkingIoTClientMessageHandler());
        try {
            parkingIoTClient.sendMessage("test message");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

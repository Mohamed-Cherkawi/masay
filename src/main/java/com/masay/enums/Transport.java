package com.masay.enums;

public enum Transport {
    MOTO("moto") ,
    CAR("car") ,
    BIKE("bike") ;

    private String transport;

    Transport(String transport) {
        this.transport = transport;
    }
}

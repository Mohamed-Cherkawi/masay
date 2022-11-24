package com.masay.enums;

public enum Status {
    OFFLINE("offline") ,
    ONLINE("online") ,
    PENDING("pending") ,
    DELIVERED("delivered");

    private String status ;

    Status(String status) {
        this.status = status;
    }
}

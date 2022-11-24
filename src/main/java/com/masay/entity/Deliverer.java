package com.masay.entity;

import com.masay.enums.Transport;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "deliverers")
public class Deliverer extends User {
    private Transport transport;

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
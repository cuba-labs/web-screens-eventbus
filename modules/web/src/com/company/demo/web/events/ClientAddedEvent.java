package com.company.demo.web.events;

import com.company.demo.entity.Client;

public class ClientAddedEvent {
    private final Client client;

    public ClientAddedEvent(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
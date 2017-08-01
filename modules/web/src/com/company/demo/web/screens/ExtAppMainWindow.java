package com.company.demo.web.screens;

import com.google.common.eventbus.EventBus;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;

public class ExtAppMainWindow extends AppMainWindow {
    private EventBus eventBus = new EventBus();

    public void subscribe(Object listener) {
        eventBus.register(listener);
    }

    public void unsubscribe(Object listener) {
        eventBus.register(listener);
    }

    public void triggerEvent(Object event) {
        eventBus.post(event);
    }
}
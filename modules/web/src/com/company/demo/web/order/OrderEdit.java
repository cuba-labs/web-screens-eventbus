package com.company.demo.web.order;

import com.company.demo.entity.Client;
import com.company.demo.entity.Order;
import com.company.demo.web.events.ClientAddedEvent;
import com.company.demo.web.screens.ExtAppMainWindow;
import com.google.common.eventbus.Subscribe;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.web.App;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class OrderEdit extends AbstractEditor<Order> {
    @Inject
    private CollectionDatasource<Client, UUID> clientsDs;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        ExtAppMainWindow mainWindow = ((ExtAppMainWindow) App.getInstance().getTopLevelWindow());
        mainWindow.subscribe(this);

        addCloseListener(actionId ->
                mainWindow.unsubscribe(this)
        );
    }

    // Google EventBus event handler
    @Subscribe
    public void onClientAdded(ClientAddedEvent event) {
        // refresh clients ds
        clientsDs.refresh();
    }
}
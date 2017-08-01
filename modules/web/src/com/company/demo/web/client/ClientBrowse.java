package com.company.demo.web.client;

import com.company.demo.entity.Client;
import com.company.demo.web.events.ClientAddedEvent;
import com.company.demo.web.screens.ExtAppMainWindow;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.web.App;

import javax.inject.Named;
import java.util.Map;

public class ClientBrowse extends AbstractLookup {
    @Named("clientsTable.create")
    private CreateAction clientsTableCreate;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        clientsTableCreate.setAfterCommitHandler(entity -> {
            ExtAppMainWindow topLevelWindow = ((ExtAppMainWindow) App.getInstance().getTopLevelWindow());
            topLevelWindow.triggerEvent(new ClientAddedEvent((Client) entity));
        });
    }
}
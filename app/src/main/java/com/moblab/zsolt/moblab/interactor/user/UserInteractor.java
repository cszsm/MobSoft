package com.moblab.zsolt.moblab.interactor.user;

import com.google.common.eventbus.EventBus;
import com.moblab.zsolt.moblab.MobSoftApplication;
import com.moblab.zsolt.moblab.interactor.user.event.LoginEvent;
import com.moblab.zsolt.moblab.model.User;
import com.moblab.zsolt.moblab.repository.Repository;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 05. 12..
 */

public class UserInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public UserInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void login(User user) {
        LoginEvent event = new LoginEvent();
        try {
            // TODO: login
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void signUp(User user) {
        LoginEvent event = new LoginEvent();
        try {
            // TODO: sign up
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}

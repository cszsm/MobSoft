package com.moblab.zsolt.moblab.ui.registration;

import com.google.common.eventbus.EventBus;
import com.moblab.zsolt.moblab.interactor.user.UserInteractor;
import com.moblab.zsolt.moblab.model.User;
import com.moblab.zsolt.moblab.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import static com.moblab.zsolt.moblab.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 05. 12..
 */

public class RegistrationPresenter extends Presenter<RegistrationScreen> {

    @Inject
    UserInteractor userInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    private static RegistrationPresenter instance = null;

    @Override
    public void attachScreen(RegistrationScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }

    public void signUp(final User user) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userInteractor.signUp(user);
            }
        });
    }
}

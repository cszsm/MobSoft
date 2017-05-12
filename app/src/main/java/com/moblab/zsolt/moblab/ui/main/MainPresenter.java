package com.moblab.zsolt.moblab.ui.main;

import com.google.common.eventbus.EventBus;
import com.moblab.zsolt.moblab.interactor.user.UserInteractor;
import com.moblab.zsolt.moblab.model.User;
import com.moblab.zsolt.moblab.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import static com.moblab.zsolt.moblab.MobSoftApplication.injector;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    UserInteractor userInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    private static MainPresenter instance = null;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }

    public void login(final User user) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userInteractor.login(user);
            }
        });
    }
}

package com.moblab.zsolt.moblab.ui.main;

import android.util.Log;

import com.moblab.zsolt.moblab.interactor.user.UserInteractor;
import com.moblab.zsolt.moblab.interactor.user.event.LoginEvent;
import com.moblab.zsolt.moblab.interactor.user.event.SignUpEvent;
import com.moblab.zsolt.moblab.model.User;
import com.moblab.zsolt.moblab.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.moblab.zsolt.moblab.MobSoftApplication.injector;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    UserInteractor userInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

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

    public void onEvent(LoginEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
        } else {
            if (screen != null) {
                screen.navigateToList();
            }
        }
    }
}

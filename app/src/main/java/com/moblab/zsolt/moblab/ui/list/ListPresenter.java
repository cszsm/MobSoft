package com.moblab.zsolt.moblab.ui.list;

import com.moblab.zsolt.moblab.interactor.coffee.CoffeeInteractor;
import com.moblab.zsolt.moblab.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.moblab.zsolt.moblab.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 05. 12..
 */

public class ListPresenter extends Presenter<ListScreen> {

    @Inject
    CoffeeInteractor coffeeInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(ListScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }
}

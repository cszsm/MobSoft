package com.moblab.zsolt.moblab.ui.add;

import android.util.Log;

import com.moblab.zsolt.moblab.interactor.coffee.CoffeeInteractor;
import com.moblab.zsolt.moblab.interactor.coffee.event.SaveCoffeeEvent;
import com.moblab.zsolt.moblab.model.Coffee;
import com.moblab.zsolt.moblab.ui.Presenter;
import com.moblab.zsolt.moblab.ui.details.DetailsScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.moblab.zsolt.moblab.MobSoftApplication.injector;

/**
 * Created by Zsolt on 2017. 05. 19..
 */

public class AddCoffeePresenter extends Presenter<AddCoffeeScreen> {

    @Inject
    CoffeeInteractor coffeeInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(AddCoffeeScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }

    public void saveCoffee(final Coffee coffee) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                coffeeInteractor.saveCoffee(coffee);
            }
        });
    }

    public void onEvent(SaveCoffeeEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                Log.d("error", "error");
            }
        } else {
            if (screen != null) {

            }
        }
    }
}

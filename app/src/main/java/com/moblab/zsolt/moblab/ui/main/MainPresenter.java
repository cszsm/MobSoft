package com.moblab.zsolt.moblab.ui.main;

import com.moblab.zsolt.moblab.interactor.coffee.CoffeeInteractor;
import com.moblab.zsolt.moblab.ui.Presenter;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    CoffeeInteractor coffeeInteractor;

    private static MainPresenter instance = null;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}

package com.moblab.zsolt.moblab.ui.main;

import com.moblab.zsolt.moblab.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {

<<<<<<< HEAD
    private static MainPresenter instance = null;

    private MainPresenter() {
    }

    public static MainPresenter getInstance() {
        if (instance == null) {
            instance = new MainPresenter();
        }
        return instance;
    }

=======
>>>>>>> d9a08a70c4e40d25608b5f0475b34bcb111b8f3a
    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
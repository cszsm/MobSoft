package com.moblab.zsolt.moblab;

import android.app.Application;

import com.moblab.zsolt.moblab.repository.Repository;
import com.moblab.zsolt.moblab.ui.UIModule;

import javax.inject.Inject;

/**
 * Created by Zsolt on 2017. 03. 31..
 */

public class MobSoftApplication extends Application {

    @Inject
    Repository repository;

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();

        injector.inject(this);
        repository.open(getApplicationContext());
    }
}

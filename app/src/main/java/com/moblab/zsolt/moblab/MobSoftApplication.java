package com.moblab.zsolt.moblab;

import android.app.Application;

import com.moblab.zsolt.moblab.ui.UIModule;

/**
 * Created by Zsolt on 2017. 03. 31..
 */

public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}

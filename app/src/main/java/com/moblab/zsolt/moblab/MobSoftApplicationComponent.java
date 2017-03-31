package com.moblab.zsolt.moblab;

import com.moblab.zsolt.moblab.ui.UIModule;
import com.moblab.zsolt.moblab.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

}
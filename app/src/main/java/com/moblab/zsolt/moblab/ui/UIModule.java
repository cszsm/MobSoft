package com.moblab.zsolt.moblab.ui;

import android.content.Context;

import com.moblab.zsolt.moblab.ui.list.ListPresenter;
import com.moblab.zsolt.moblab.ui.main.MainPresenter;
import com.moblab.zsolt.moblab.ui.registration.RegistrationPresenter;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public RegistrationPresenter provideRegistrationPresenter() {
        return new RegistrationPresenter();
    }

    @Provides
    @Singleton
    public ListPresenter provideListPresenter() {
        return new ListPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }

}
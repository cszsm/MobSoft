package com.moblab.zsolt.moblab;

import com.moblab.zsolt.moblab.interactor.InteractorModule;
import com.moblab.zsolt.moblab.interactor.coffee.CoffeeInteractor;
import com.moblab.zsolt.moblab.repository.RepositoryModule;
import com.moblab.zsolt.moblab.ui.UIModule;
import com.moblab.zsolt.moblab.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(MobSoftApplication mobSoftApplication);

    void inject(CoffeeInteractor coffeeInteractor);
}
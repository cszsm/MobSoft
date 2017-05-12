package com.moblab.zsolt.moblab;

import com.moblab.zsolt.moblab.interactor.InteractorModule;
import com.moblab.zsolt.moblab.interactor.coffee.CoffeeInteractor;
import com.moblab.zsolt.moblab.interactor.user.UserInteractor;
import com.moblab.zsolt.moblab.repository.RepositoryModule;
import com.moblab.zsolt.moblab.ui.UIModule;
import com.moblab.zsolt.moblab.ui.list.ListActivity;
import com.moblab.zsolt.moblab.ui.list.ListPresenter;
import com.moblab.zsolt.moblab.ui.main.MainActivity;
import com.moblab.zsolt.moblab.ui.main.MainPresenter;
import com.moblab.zsolt.moblab.ui.registration.RegistrationActivity;
import com.moblab.zsolt.moblab.ui.registration.RegistrationPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {

    void inject(MobSoftApplication mobSoftApplication);

    void inject(CoffeeInteractor coffeeInteractor);

    void inject(UserInteractor userInteractor);

    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);

    void inject(RegistrationActivity registrationActivity);

    void inject(RegistrationPresenter registrationPresenter);

    void inject(ListActivity listActivity);

    void inject(ListPresenter listPresenter);
}
package com.moblab.zsolt.moblab.interactor;

import com.moblab.zsolt.moblab.interactor.coffee.CoffeeInteractor;
import com.moblab.zsolt.moblab.interactor.user.UserInteractor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

@Module
public class InteractorModule {

    @Provides
    public CoffeeInteractor provideCoffee() {
        return new CoffeeInteractor();
    }

    @Provides
    public UserInteractor provideUser() {
        return new UserInteractor();
    }
}

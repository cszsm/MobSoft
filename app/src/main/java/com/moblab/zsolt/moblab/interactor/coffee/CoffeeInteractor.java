package com.moblab.zsolt.moblab.interactor.coffee;

import com.moblab.zsolt.moblab.MobSoftApplication;
import com.moblab.zsolt.moblab.model.Coffee;
import com.moblab.zsolt.moblab.repository.Repository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class CoffeeInteractor {

    @Inject
    Repository repository;

    public CoffeeInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getCoffees() {
        List<Coffee> coffes = repository.getCoffees();
    }

    public void saveCoffee(Coffee coffee) {
        repository.saveCoffee(coffee);
    }

    public void updateCoffees(List<Coffee> coffees) {
        try {
            repository.updateCoffees(coffees);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeCoffee(Coffee coffee) {
        repository.removeCoffee(coffee);
    }
}

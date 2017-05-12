package com.moblab.zsolt.moblab.interactor.coffee;

import com.google.common.eventbus.EventBus;
import com.moblab.zsolt.moblab.MobSoftApplication;
import com.moblab.zsolt.moblab.interactor.coffee.event.GetCoffeeEvent;
import com.moblab.zsolt.moblab.interactor.coffee.event.RemoveCoffeeEvent;
import com.moblab.zsolt.moblab.interactor.coffee.event.SaveCoffeeEvent;
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

    @Inject
    EventBus bus;

    public CoffeeInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getCoffees() {
        GetCoffeeEvent event = new GetCoffeeEvent();
        try {
            List<Coffee> coffees = repository.getCoffees();
            event.setCoffees(coffees);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveCoffee(Coffee coffee) {
        SaveCoffeeEvent event = new SaveCoffeeEvent();
        event.setCoffee(coffee);
        try {
            repository.saveCoffee(coffee);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void updateCoffees(List<Coffee> coffees) {
        try {
            repository.updateCoffees(coffees);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeCoffee(Coffee coffee) {
        RemoveCoffeeEvent event = new RemoveCoffeeEvent();
        event.setCoffee(coffee);
        try {
            repository.removeCoffee(coffee);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}

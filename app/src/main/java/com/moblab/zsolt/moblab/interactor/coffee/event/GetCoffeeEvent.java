package com.moblab.zsolt.moblab.interactor.coffee.event;

import com.moblab.zsolt.moblab.model.Coffee;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class GetCoffeeEvent {

    private int code;
    private List<Coffee> coffees;
    private Throwable throwable;

    public GetCoffeeEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

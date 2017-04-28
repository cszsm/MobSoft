package com.moblab.zsolt.moblab.interactor.coffee.event;

import com.moblab.zsolt.moblab.model.Coffee;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class RemoveCoffeeEvent {

    private int code;
    private Coffee coffee;
    private Throwable throwable;

    public RemoveCoffeeEvent() {
    }

    public RemoveCoffeeEvent(int code, Coffee coffee, Throwable throwable) {
        this.code = code;
        this.coffee = coffee;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

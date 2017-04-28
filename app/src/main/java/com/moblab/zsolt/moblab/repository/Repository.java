package com.moblab.zsolt.moblab.repository;

import android.content.Context;

import com.moblab.zsolt.moblab.model.Coffee;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public interface Repository {

    void open(Context context);

    void close();

    List<Coffee> getCoffees();

    void saveCoffee(Coffee coffee);

    void updateCoffees(List<Coffee> coffees);

    void removeCoffee(Coffee coffee);

    boolean isInDB(Coffee coffee);
}

package com.moblab.zsolt.moblab.repository;

import android.content.Context;

import com.moblab.zsolt.moblab.model.Coffee;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Coffee> getCoffees() {
        return SugarRecord.listAll(Coffee.class);
    }

    @Override
    public void saveCoffee(Coffee coffee) {
        SugarRecord.saveInTx(coffee);
    }

    @Override
    public void updateCoffees(List<Coffee> newCoffees) {
        List<Coffee> oldCoffees = getCoffees();
        List<Coffee> toUpdate = new ArrayList<>(oldCoffees.size());
        for(Coffee oldCoffee : oldCoffees) {
            for(Coffee newCoffee : newCoffees) {
                if (newCoffee.getId().equals(oldCoffee.getId())) {
                    toUpdate.add(newCoffee);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }

    @Override
    public void removeCoffee(Coffee coffee) {
        SugarRecord.deleteInTx(coffee);
    }

    @Override
    public boolean isInDB(Coffee coffee) {
        return SugarRecord.findById(Coffee.class, coffee.getId()) != null;
    }
}

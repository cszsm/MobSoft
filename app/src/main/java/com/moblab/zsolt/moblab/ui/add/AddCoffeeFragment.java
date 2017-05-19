package com.moblab.zsolt.moblab.ui.add;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.moblab.zsolt.moblab.R;
import com.moblab.zsolt.moblab.model.Coffee;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Zsolt on 2017. 05. 19..
 */

public class AddCoffeeFragment extends DialogFragment implements AddCoffeeScreen {

    @Inject
    AddCoffeePresenter presenter;

    ItemContainer itemContainer;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        itemContainer = (ItemContainer) context;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachScreen(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_add_coffee, container, false);

        getDialog().setTitle("Add coffee");

        final EditText name = (EditText) root.findViewById(R.id.et_name);
        final TextView ingredients = (TextView) root.findViewById(R.id.tv_ingredients);
        final EditText newIngredient = (EditText) root.findViewById(R.id.et_ingredient);
        Button addIngredient = (Button) root.findViewById(R.id.btn_add);
        final EditText preparation = (EditText) root.findViewById(R.id.et_preparation);
        Button ok = (Button) root.findViewById(R.id.btn_ok);

        final List<String> ingredientList = new ArrayList<>();

        addIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredientList.add(String.valueOf(newIngredient.getText()));
                ingredients.setText(getIngredients(ingredientList));
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Coffee coffee = new Coffee();
                coffee.setName(String.valueOf(name.getText()));
                coffee.setIngredients(ingredientList);
                coffee.setPreparation(String.valueOf(preparation.getText()));
                presenter.saveCoffee(coffee);
                itemContainer.update();
                dismiss();
            }
        });



        return root;
    }

    private String getIngredients(List<String> list) {
        String ingredients = "";
        for(String ingredient : list) {
            ingredients += ingredient + "\n";
        }
        return ingredients;
    }

    public interface ItemContainer {
        void update();
    }
}

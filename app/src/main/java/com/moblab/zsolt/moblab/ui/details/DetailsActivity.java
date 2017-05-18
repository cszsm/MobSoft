package com.moblab.zsolt.moblab.ui.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.moblab.zsolt.moblab.R;
import com.moblab.zsolt.moblab.model.Coffee;

import java.util.List;
import java.util.StringTokenizer;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Coffee coffee = intent.getParcelableExtra("COFFEE");

        TextView ingredients = (TextView) findViewById(R.id.tv_ingredients);
        ingredients.setText(getIngredients(coffee.getIngredients()));

        TextView preparation = (TextView) findViewById(R.id.tv_preparation);
        preparation.setText(coffee.getPreparation());
    }

    private String getIngredients(List<String> list) {
        String ingredients = "";
        for(String ingredient : list) {
            ingredients += ingredient + "\n";
        }
        return ingredients;
    }
}

package com.moblab.zsolt.moblab.ui.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.moblab.zsolt.moblab.R;
import com.moblab.zsolt.moblab.model.Coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static com.moblab.zsolt.moblab.MobSoftApplication.injector;

public class ListActivity extends AppCompatActivity implements ListScreen {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        injector.inject(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv_coffees);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CoffeeListAdapter(getExamples());
        recyclerView.setAdapter(adapter);
    }

    private List<Coffee> getExamples() {
        List<Coffee> examples = new ArrayList<>();

        List<String> iBicerin = new ArrayList<>();
        iBicerin.add("espresso");
        iBicerin.add("gianduja");
        iBicerin.add("milk");

        List<String> iWienerMelange = new ArrayList<>();
        iWienerMelange.add("espresso");
        iWienerMelange.add("milk");

        List<String> iLatteMacchiato = new ArrayList<>();
        iLatteMacchiato.add("espresso");
        iLatteMacchiato.add("milk");
        iLatteMacchiato.add("foam");

        examples.add(new Coffee(1l, "bicerin", iBicerin, "dolgok"));
        examples.add(new Coffee(2l, "wiener melange", iWienerMelange, "dolgok"));
        examples.add(new Coffee(3l, "latte macchiato", iLatteMacchiato, "dolgok"));

        return examples;
    }
}

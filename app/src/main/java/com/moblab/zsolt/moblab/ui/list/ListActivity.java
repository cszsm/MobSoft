package com.moblab.zsolt.moblab.ui.list;

import android.app.FragmentManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.moblab.zsolt.moblab.R;
import com.moblab.zsolt.moblab.model.Coffee;
import com.moblab.zsolt.moblab.ui.add.AddCoffeeFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.moblab.zsolt.moblab.MobSoftApplication.injector;

public class ListActivity extends AppCompatActivity implements ListScreen, AddCoffeeFragment.ItemContainer {

    @Inject
    ListPresenter presenter;

    private RecyclerView recyclerView;
    private CoffeeListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Coffee> coffees;

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

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCoffeeFragment fragment = new AddCoffeeFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragment.show(fragmentManager, "FRAGMENT_TAG");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
        presenter.getCoffees();
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

    @Override
    public void showCoffees(List<Coffee> coffees) {
        adapter.update(getExamples());
    }

    @Override
    public void update() {
        adapter.update(getExamples());
    }
}

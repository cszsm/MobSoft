package com.moblab.zsolt.moblab.ui.list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moblab.zsolt.moblab.R;
import com.moblab.zsolt.moblab.model.Coffee;
import com.moblab.zsolt.moblab.ui.details.DetailsActivity;

import java.util.List;

/**
 * Created by Zsolt on 2017. 05. 18..
 */

public class CoffeeListAdapter extends RecyclerView.Adapter<CoffeeListAdapter.ViewHolder> {

    private List<Coffee> coffees;

    public CoffeeListAdapter(List<Coffee> coffees) {
        this.coffees = coffees;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.coffee = coffees.get(position);
        holder.textView.setText(holder.coffee.getName());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("COFFEE", holder.coffee);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return coffees.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView textView;
        public Coffee coffee;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            this.textView = (TextView) view.findViewById(R.id.coffee_name);
        }
    }

    public void update(List<Coffee> coffees) {
        this.coffees = coffees;
        notifyDataSetChanged();
    }
}

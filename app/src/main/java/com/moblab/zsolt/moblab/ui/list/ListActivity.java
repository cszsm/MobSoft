package com.moblab.zsolt.moblab.ui.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.moblab.zsolt.moblab.R;

public class ListActivity extends AppCompatActivity implements ListScreen{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
}

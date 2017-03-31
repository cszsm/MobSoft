package com.moblab.zsolt.moblab.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

<<<<<<< HEAD
import com.moblab.zsolt.moblab.R;

public class MainActivity extends AppCompatActivity implements MainScreen {

=======
import com.moblab.zsolt.moblab.MobSoftApplication;
import com.moblab.zsolt.moblab.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

>>>>>>> d9a08a70c4e40d25608b5f0475b34bcb111b8f3a
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
=======

        MobSoftApplication.injector.inject(this);
>>>>>>> d9a08a70c4e40d25608b5f0475b34bcb111b8f3a
    }

    @Override
    protected void onStart() {
        super.onStart();
<<<<<<< HEAD
        MainPresenter.getInstance().attachScreen(this);
=======
        mainPresenter.attachScreen(this);
>>>>>>> d9a08a70c4e40d25608b5f0475b34bcb111b8f3a
    }

    @Override
    protected void onStop() {
        super.onStop();
<<<<<<< HEAD
        MainPresenter.getInstance().detachScreen();
=======
        mainPresenter.detachScreen();
>>>>>>> d9a08a70c4e40d25608b5f0475b34bcb111b8f3a
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}

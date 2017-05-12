package com.moblab.zsolt.moblab.ui.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.moblab.zsolt.moblab.MobSoftApplication;
import com.moblab.zsolt.moblab.R;

import javax.inject.Inject;

public class RegistrationActivity extends AppCompatActivity implements RegistrationScreen {

    @Inject
    RegistrationPresenter registrationPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registrationPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        registrationPresenter.detachScreen();
    }
}

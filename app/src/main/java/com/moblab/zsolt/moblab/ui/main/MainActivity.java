package com.moblab.zsolt.moblab.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.moblab.zsolt.moblab.MobSoftApplication;
import com.moblab.zsolt.moblab.R;
import com.moblab.zsolt.moblab.model.User;
import com.moblab.zsolt.moblab.ui.list.ListActivity;
import com.moblab.zsolt.moblab.ui.registration.RegistrationActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobSoftApplication.injector.inject(this);

        final EditText usernameText = (EditText) findViewById(R.id.et_username);
        final EditText passwordText = (EditText) findViewById(R.id.et_password);

        Button loginButton = (Button) findViewById(R.id.bnt_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();

                user.setUsername(String.valueOf(usernameText.getText()));
                user.setPassword(String.valueOf(passwordText.getText()));

                presenter.login(user);
            }
        });

        Button signUpButton = (Button) findViewById(R.id.btn_signUp);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSignUp();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToList() {
        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(intent);
    }

    public void navigateToSignUp() {
        Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
        startActivity(intent);
    }
}

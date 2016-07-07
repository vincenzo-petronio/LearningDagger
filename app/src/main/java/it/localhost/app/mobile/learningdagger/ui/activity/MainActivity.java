package it.localhost.app.mobile.learningdagger.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import it.localhost.app.mobile.learningdagger.AddressBookApplication;
import it.localhost.app.mobile.learningdagger.R;
import it.localhost.app.mobile.learningdagger.data.model.User;
import it.localhost.app.mobile.learningdagger.ui.dagger.modules.MainActivityModule;
import it.localhost.app.mobile.learningdagger.ui.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText etUser, etPsw;
    private TextView networkAvailable;
    @Inject
    MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        // VIEW
        setContentView(R.layout.activity_main);
        networkAvailable = (TextView) findViewById(R.id.target);
        etUser = (EditText) findViewById(R.id.etUser);
        etPsw = (EditText) findViewById(R.id.etPsw);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBtnLoginClick();

            }
        });

        // INIT
        initDependencyInjector();
    }

    private void initDependencyInjector() {
        ((AddressBookApplication) getApplication()).getAppComponent().inject(new MainActivityModule(this)).inject(this);
    }

    public void onLoginError() {
        Log.e(TAG, "User not logged!");
        // TODO
    }

    public void onLoginSuccess() {
        Log.i(TAG, "User logged!");
        startActivity(new Intent(MainActivity.this, ContactsListActivity.class));
    }

    private void onBtnLoginClick() {
        // D'oh!!! creata una dipendenza con User :-/
        User user = new User();
        user.setUsername(etUser.getText().toString().trim());
        user.setPassword(etPsw.getText().toString().trim());
        mainActivityPresenter.onLoginClick(user);
    }

    /**
     * @param s
     */
    public void setNetworkAvailable(String s) {
        networkAvailable.setText("Dependency injection worked: " + s);
    }
}

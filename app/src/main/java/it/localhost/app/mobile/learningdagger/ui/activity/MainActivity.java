package it.localhost.app.mobile.learningdagger.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import it.localhost.app.mobile.learningdagger.AddressBookApplication;
import it.localhost.app.mobile.learningdagger.R;
import it.localhost.app.mobile.learningdagger.utils.NetworkApi;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Inject
    NetworkApi networkApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // VIEW
        setContentView(R.layout.activity_main);

        ((AddressBookApplication) getApplication()).getAppComponent().inject(this);

        boolean injected =  networkApi == null ? false : true;
        TextView userAvailable = (TextView) findViewById(R.id.target);
        userAvailable.setText("Dependency injection worked: " + String.valueOf(injected));

        final EditText etUser = (EditText) findViewById(R.id.etUser);
        final EditText etPsw = (EditText) findViewById(R.id.etPsw);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(networkApi.isUserAuth(etUser.getText().toString(), etPsw.getText().toString())) {
                    Log.i(TAG, "User logged!");
//                    startActivity(new Intent(MainActivity.this, ContactsListActivity.class));
                } else {
                    Log.e(TAG, "User not logged!");
                }
            }
        });

    }
}

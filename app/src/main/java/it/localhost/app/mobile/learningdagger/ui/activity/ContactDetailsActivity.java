package it.localhost.app.mobile.learningdagger.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import javax.inject.Inject;

import it.localhost.app.mobile.learningdagger.AddressBookApplication;
import it.localhost.app.mobile.learningdagger.R;
import it.localhost.app.mobile.learningdagger.data.model.Contact;
import it.localhost.app.mobile.learningdagger.ui.dagger.modules.ContactDetailsActivityModule;
import it.localhost.app.mobile.learningdagger.ui.presenter.ContactDetailsActivityPresenter;

public class ContactDetailsActivity extends AppCompatActivity {

    private static final String TAG = "ContactDetailsActivity";
    @Inject
    ContactDetailsActivityPresenter contactDetailsActivityPresenter;
    private TextView tvNameSurname, tvBirthday, tvSex;
    private Contact bndContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        // BUNDLE
        bndContact = new Gson().fromJson(getIntent().getStringExtra("KEY_CONTACT"), Contact.class);

        // VIEW
        setContentView(R.layout.activity_contact_details);
        tvNameSurname = (TextView) findViewById(R.id.tvNameSurname);
        tvBirthday = (TextView) findViewById(R.id.tvBirthday);
        tvSex = (TextView) findViewById(R.id.tvSex);

        initDependencyInjector();
        setupView();
    }

    private void initDependencyInjector() {
        ((AddressBookApplication) getApplication()).getAppComponent()
                .inject(new ContactDetailsActivityModule(this)).inject(this);
    }

    private void setupView() {
        Log.v(TAG, "setupView");
        tvNameSurname.setText(bndContact.getName() + " " + bndContact.getSurname());
        tvBirthday.setText(bndContact.getBirthday());
        tvSex.setText(String.valueOf(bndContact.getSex()));
    }

}

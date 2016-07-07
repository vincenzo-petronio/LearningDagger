package it.localhost.app.mobile.learningdagger.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import it.localhost.app.mobile.learningdagger.AddressBookApplication;
import it.localhost.app.mobile.learningdagger.R;
import it.localhost.app.mobile.learningdagger.data.model.Contact;
import it.localhost.app.mobile.learningdagger.ui.adapter.ContactsListAdapter;
import it.localhost.app.mobile.learningdagger.ui.dagger.modules.ContactsListActivityModule;
import it.localhost.app.mobile.learningdagger.ui.presenter.ContactsListActivityPresenter;

public class ContactsListActivity extends AppCompatActivity {

    private static final String TAG = "ContactsListActivity";
    @Inject
    ContactsListActivityPresenter presenter;
    @Inject
    ContactsListAdapter lvContactsAdapter;
    private ListView lvContacts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        // VIEW
        setContentView(R.layout.activity_contactslist);
        lvContacts = (ListView) findViewById(R.id.lvContacts);

        initDependencyInjector();
        setupView();
        presenter.loadData();
    }

    private void initDependencyInjector() {
        ((AddressBookApplication) getApplication()).getAppComponent()
                .inject(new ContactsListActivityModule(this)).inject(this);
    }

    private void setupView() {
        Log.v(TAG, "setupView");
        lvContacts.setAdapter(lvContactsAdapter);
        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact c = (Contact) adapterView.getAdapter().getItem(i);

                Intent intent = new Intent(ContactsListActivity.this, ContactDetailsActivity.class);
                intent.putExtra("KEY_CONTACT", new Gson().toJson(c));
                startActivity(intent);
            }
        });
    }

    public void setContacts(List<Contact> contacts) {
        Log.v(TAG, "setContacts");
        lvContactsAdapter.updateContactsList(contacts);
    }


}

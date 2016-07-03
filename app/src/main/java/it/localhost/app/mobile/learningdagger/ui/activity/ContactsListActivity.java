//package it.localhost.app.mobile.learningdagger.ui.activity;
//
//import android.os.Bundle;
//import android.os.PersistableBundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//
//import java.util.List;
//
//import javax.inject.Inject;
//
//import it.localhost.app.mobile.learningdagger.AddressBookApplication;
//import it.localhost.app.mobile.learningdagger.R;
//import it.localhost.app.mobile.learningdagger.data.model.Contact;
//import it.localhost.app.mobile.learningdagger.ui.adapter.ContactsListAdapter;
//import it.localhost.app.mobile.learningdagger.ui.presenter.ContactsListActivityPresenter;
//
//public class ContactsListActivity extends AppCompatActivity {
//
//    @Inject
//    ContactsListActivityPresenter presenter;
//    @Inject
//    ContactsListAdapter lvContactsAdapter;
//    private ListView lvContacts;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//
//        // VIEW
//        setContentView(R.layout.activity_contactslist);
//        lvContacts = (ListView) findViewById(R.id.lvContacts);
//
//        setupActivityComponent();
//        setupView();
//        presenter.loadData();
//    }
//
//    @Override
//    public void finish() {
//        super.finish();
//    }
//
//    private void setupActivityComponent() {
//        ((AddressBookApplication) getApplication()).getAppComponent().inject(this);
//    }
//
//    private void setupView() {
//        lvContacts.setAdapter(lvContactsAdapter);
//        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                // TODO => details
//            }
//        });
//    }
//
//    public void setContacts(List<Contact> contacts) {
//        lvContactsAdapter.updateContactsList(contacts);
//    }
//
//
//}

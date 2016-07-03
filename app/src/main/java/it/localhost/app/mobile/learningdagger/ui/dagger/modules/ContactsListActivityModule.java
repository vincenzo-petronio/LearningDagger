//package it.localhost.app.mobile.learningdagger.ui.dagger.modules;
//
//import dagger.Module;
//import dagger.Provides;
//import it.localhost.app.mobile.learningdagger.data.model.ContactsManager;
//import it.localhost.app.mobile.learningdagger.ui.activity.ContactsListActivity;
//import it.localhost.app.mobile.learningdagger.ui.adapter.ContactsListAdapter;
//import it.localhost.app.mobile.learningdagger.ui.presenter.ContactsListActivityPresenter;
//
//@Module
//public class ContactsListActivityModule {
//    private ContactsListActivity contactsListActivity;
//
//    public ContactsListActivityModule(ContactsListActivity contactsListActivity) {
//        this.contactsListActivity = contactsListActivity;
//    }
//
//    @Provides
//    ContactsListActivity provideContactsListActivity() {
//        return contactsListActivity;
//    }
//
//    @Provides
//    ContactsListActivityPresenter provideContactsListActivityPresenter(ContactsManager contactsManager) {
//        return new ContactsListActivityPresenter(contactsListActivity, contactsManager);
//    }
//
//    @Provides
//    ContactsListAdapter provideContactsListAdapter(ContactsListActivity contactsListActivity) {
//        return new ContactsListAdapter((contactsListActivity));
//    }
//}

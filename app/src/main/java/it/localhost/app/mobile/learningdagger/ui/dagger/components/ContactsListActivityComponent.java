package it.localhost.app.mobile.learningdagger.ui.dagger.components;

import javax.inject.Singleton;

import dagger.Subcomponent;
import it.localhost.app.mobile.learningdagger.dagger.modules.NetworkApiModule;
import it.localhost.app.mobile.learningdagger.ui.activity.ContactsListActivity;
import it.localhost.app.mobile.learningdagger.ui.dagger.modules.ContactsListActivityModule;

@Subcomponent(modules = {
        ContactsListActivityModule.class,
        NetworkApiModule.class
})
@Singleton
public interface ContactsListActivityComponent {

    ContactsListActivity inject(ContactsListActivity contactsListActivity);
}

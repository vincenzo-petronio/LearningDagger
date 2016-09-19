package it.localhost.app.mobile.learningdagger.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import it.localhost.app.mobile.learningdagger.dagger.modules.AppModule;
import it.localhost.app.mobile.learningdagger.ui.dagger.components.ContactDetailsActivityComponent;
import it.localhost.app.mobile.learningdagger.ui.dagger.components.ContactsListActivityComponent;
import it.localhost.app.mobile.learningdagger.ui.dagger.components.MainActivityComponent;
import it.localhost.app.mobile.learningdagger.ui.dagger.modules.ContactDetailsActivityModule;
import it.localhost.app.mobile.learningdagger.ui.dagger.modules.ContactsListActivityModule;
import it.localhost.app.mobile.learningdagger.ui.dagger.modules.MainActivityModule;

/**
 * Dagger Component.<br>
 * I Component dicono dove effettuare l'injection dei moduli.<br>
 */
@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {
    // Serve per istruire Dagger sui Module disponibili e sugli objects che sono 'injectable',
    // cioè i target.

    MainActivityComponent inject(MainActivityModule mainActivityModule);

    ContactsListActivityComponent inject(ContactsListActivityModule contactsListActivityModule);

    ContactDetailsActivityComponent inject(ContactDetailsActivityModule contactDetailsActivityModule);
}

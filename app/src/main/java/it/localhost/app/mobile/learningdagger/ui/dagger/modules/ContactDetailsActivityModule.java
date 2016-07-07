package it.localhost.app.mobile.learningdagger.ui.dagger.modules;

import dagger.Module;
import dagger.Provides;
import it.localhost.app.mobile.learningdagger.ui.activity.ContactDetailsActivity;
import it.localhost.app.mobile.learningdagger.ui.presenter.ContactDetailsActivityPresenter;

@Module
public class ContactDetailsActivityModule {
    private ContactDetailsActivity contactDetailsActivity;

    public ContactDetailsActivityModule(ContactDetailsActivity contactDetailsActivity) {
        this.contactDetailsActivity = contactDetailsActivity;
    }

    @Provides
    ContactDetailsActivityPresenter provideContactDetailsActivityPresenter() {
        return new ContactDetailsActivityPresenter(contactDetailsActivity);
    }
}

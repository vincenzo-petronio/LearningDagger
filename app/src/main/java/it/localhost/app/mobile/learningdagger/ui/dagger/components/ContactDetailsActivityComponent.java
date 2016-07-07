package it.localhost.app.mobile.learningdagger.ui.dagger.components;

import dagger.Subcomponent;
import it.localhost.app.mobile.learningdagger.ui.activity.ContactDetailsActivity;
import it.localhost.app.mobile.learningdagger.ui.dagger.modules.ContactDetailsActivityModule;

@Subcomponent(modules = {
        ContactDetailsActivityModule.class
})
public interface ContactDetailsActivityComponent {

    ContactDetailsActivity inject(ContactDetailsActivity contactDetailsActivity);
}

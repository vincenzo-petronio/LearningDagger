package it.localhost.app.mobile.learningdagger.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import it.localhost.app.mobile.learningdagger.ui.activity.MainActivity;
import it.localhost.app.mobile.learningdagger.dagger.modules.AppModule;
import it.localhost.app.mobile.learningdagger.dagger.modules.NetworkApiModule;

/**
 * Dagger Component.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                NetworkApiModule.class
        }
)
public interface AppComponent {
    // Serve per istruire Dagger sui Module disponibili e sugli objects che sono 'injectable',
    // cioè i target.

    void inject(MainActivity activity);
}

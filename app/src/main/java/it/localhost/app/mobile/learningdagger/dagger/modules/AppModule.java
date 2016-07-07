package it.localhost.app.mobile.learningdagger.dagger.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import it.localhost.app.mobile.learningdagger.AddressBookApplication;
import it.localhost.app.mobile.learningdagger.utils.NetworkStateManager;

/**
 * Dagger Module per fornire le dipendenze globali
 */
@Module
public class AppModule {
    private final AddressBookApplication app;

    public AppModule(AddressBookApplication app) {
        this.app = app;
    }

    // I metodi che forniscono gli oggetti per la dependencies injection sono annotati
    // come @Provides.

    /**
     * Fornisce una singola istanza del Context dell'applicazione
     *
     * @return Context
     */
    @Singleton
    @Provides
    public Context provideContext() {
        return app;
    }

    /**
     * Fornisce una singola istanza delle SharedPreferences
     *
     * @return SharedPreferences
     */
    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    /**
     * Fornisce una singola istanza della classe ConnectivityManager
     *
     * @return ConnectivityManager
     */
    @Provides
    @Singleton
    ConnectivityManager provideConnectivityManager() {
        return (ConnectivityManager) app.getSystemService(app.CONNECTIVITY_SERVICE);
    }

    /**
     * Fornisce una singola istanza della classe NetworkStateManager
     *
     * @param connectivityManager Dipendenza fornita attraverso un altro metodo @Provides
     * @return NetworkStateManager
     */
    @Provides
    @Singleton
    NetworkStateManager provideNetworkStateManager(ConnectivityManager connectivityManager) {
        return new NetworkStateManager(connectivityManager);
    }
}

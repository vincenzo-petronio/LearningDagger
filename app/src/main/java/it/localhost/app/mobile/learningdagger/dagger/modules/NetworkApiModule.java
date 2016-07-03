package it.localhost.app.mobile.learningdagger.dagger.modules;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import it.localhost.app.mobile.learningdagger.utils.NetworkApi;

/**
 * Dagger Module
 */
@Module
public class NetworkApiModule {

    /**
     * Fornisce una singola istanza della classe per accedere alle API
     *
     * @return NetworkApi
     */
    @Provides
    @Singleton
    public NetworkApi provideNetworkApi() {
        return new NetworkApi();
    }

}

package it.localhost.app.mobile.learningdagger.utils;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkStateManager {
    private ConnectivityManager connectivityManager;

    public NetworkStateManager(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    /**
     * Restituisce true se la connessione è stabilita, false altrimenti.
     *
     * @return boolean
     */
    public boolean isConnected() {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo.isConnected();
    }
}

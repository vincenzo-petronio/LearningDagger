package it.localhost.app.mobile.learningdagger.ui.presenter;

import android.util.Log;

import it.localhost.app.mobile.learningdagger.data.model.User;
import it.localhost.app.mobile.learningdagger.ui.activity.MainActivity;
import it.localhost.app.mobile.learningdagger.utils.NetworkApi;

public class MainActivityPresenter {

    private static final String TAG = "MainActivityPresenter";
    private MainActivity mainActivity;
    private NetworkApi networkApi;

    /**
     * @param mainActivity MainActivity
     * @param networkApi   NetworkApi
     */
    public MainActivityPresenter(MainActivity mainActivity, NetworkApi networkApi) {
        Log.v(TAG, "MainActivityPresenter");
        this.mainActivity = mainActivity;
        this.networkApi = networkApi;

        // Check se la DI funziona!
        boolean injected = this.networkApi == null ? false : true;
        this.mainActivity.setNetworkAvailable(String.valueOf(injected));
    }

    public void onLoginClick(User user) {
        if (networkApi.isUserAuth(user.getUsername(), user.getPassword())) {
            mainActivity.onLoginSuccess();
        } else {
            mainActivity.onLoginError();
        }
    }
}

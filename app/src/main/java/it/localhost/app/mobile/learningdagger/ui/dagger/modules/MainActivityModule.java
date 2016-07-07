package it.localhost.app.mobile.learningdagger.ui.dagger.modules;

import android.util.Log;

import dagger.Module;
import dagger.Provides;
import it.localhost.app.mobile.learningdagger.ui.activity.MainActivity;
import it.localhost.app.mobile.learningdagger.ui.presenter.MainActivityPresenter;
import it.localhost.app.mobile.learningdagger.utils.NetworkApi;

@Module
public class MainActivityModule {
    private static final String TAG = "MainActivityModule";
    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        Log.v(TAG, "MainActivityModule");
        this.mainActivity = mainActivity;
    }

    @Provides
    MainActivity provideMainActivity() {
        Log.v(TAG, "provideMainActivity");
        return mainActivity;
    }

    @Provides
    MainActivityPresenter provideMainActivityPresenter(NetworkApi networkApi) {
        Log.v(TAG, "provideMainActivityPresenter");
        return new MainActivityPresenter(mainActivity, networkApi);
    }
}

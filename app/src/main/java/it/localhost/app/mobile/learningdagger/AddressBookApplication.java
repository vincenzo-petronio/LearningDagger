package it.localhost.app.mobile.learningdagger;

import android.app.Application;

import it.localhost.app.mobile.learningdagger.dagger.components.AppComponent;
import it.localhost.app.mobile.learningdagger.dagger.components.DaggerAppComponent;

public class AddressBookApplication extends Application {

    private static AppComponent appComponent;
    private static AddressBookApplication instance = new AddressBookApplication();

    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
    }

    public static AddressBookApplication getInstance() {
        return instance;
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder().build();
        }
        return appComponent;
    }
}

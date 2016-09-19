package it.localhost.app.mobile.learningdagger;

import android.app.Application;

import it.localhost.app.mobile.learningdagger.dagger.components.AppComponent;
import it.localhost.app.mobile.learningdagger.dagger.components.DaggerAppComponent;
import it.localhost.app.mobile.learningdagger.dagger.modules.AppModule;


public class AddressBookApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {

            /**
             * @see <a href="http://google.github.io/dagger/api/2.0/dagger/Component.html#instantiation"></a>
             */
            appComponent = DaggerAppComponent
                    .builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }
}

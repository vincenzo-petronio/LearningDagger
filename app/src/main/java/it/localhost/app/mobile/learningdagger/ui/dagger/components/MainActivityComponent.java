package it.localhost.app.mobile.learningdagger.ui.dagger.components;

import javax.inject.Singleton;

import dagger.Subcomponent;
import it.localhost.app.mobile.learningdagger.dagger.modules.NetworkApiModule;
import it.localhost.app.mobile.learningdagger.ui.activity.MainActivity;
import it.localhost.app.mobile.learningdagger.ui.dagger.modules.MainActivityModule;

@Subcomponent(modules = {
        MainActivityModule.class,
        NetworkApiModule.class
})
@Singleton
public interface MainActivityComponent {
    MainActivity inject(MainActivity mainActivity);
}


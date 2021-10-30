package uz.gita.geographytest.App;

import android.app.Application;

public class App extends Application {
    public static App instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}

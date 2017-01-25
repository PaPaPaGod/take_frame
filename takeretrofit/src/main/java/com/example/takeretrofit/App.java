package com.example.takeretrofit;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by price on 1/25/2017.
 */

public class App extends Application{
    private static App appContext = null;
    public static App getAppContext(){
        if(appContext ==null){
            appContext = new App();
        }
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        SugarContext.terminate();
        super.onTerminate();
    }
}

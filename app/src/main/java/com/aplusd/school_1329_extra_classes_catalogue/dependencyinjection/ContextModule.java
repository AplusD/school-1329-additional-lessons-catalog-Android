package com.aplusd.school_1329_extra_classes_catalogue.dependencyinjection;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @author Azamat Dzhonov
 * @date 26.01.2018
 */

@Module
public class ContextModule  {

    private Context context = null;
    private AppCompatActivity appCompatActivity = null;

    public ContextModule(Context context, AppCompatActivity appCompatActivity)
    {
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    public Context context()
    {
        return context;
    }

    @Provides
    public AppCompatActivity appCompatActivity()
    {
        return appCompatActivity;
    }
}

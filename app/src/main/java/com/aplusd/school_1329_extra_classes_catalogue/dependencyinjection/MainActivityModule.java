package com.aplusd.school_1329_extra_classes_catalogue.dependencyinjection;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.aplusd.school_1329_extra_classes_catalogue.extraclasseswork.ExtraClassAdapter;
import com.aplusd.school_1329_extra_classes_catalogue.viewmodels.ViewModelExtraClasses;

import dagger.Module;
import dagger.Provides;

/**
 * @author Azamat Dzhonov
 * @date 25.01.2018
 */

@Module (includes = ContextModule.class)
public class MainActivityModule {

    @Provides
    public ExtraClassAdapter extraClassAdapter(Context context)
    {
        return new ExtraClassAdapter(context);
    }

    @Provides
    public ViewModelExtraClasses viewModelExtraClasses(AppCompatActivity appCompatActivity)
    {
        return ViewModelProviders.of(appCompatActivity).get(ViewModelExtraClasses.class);
    }
}

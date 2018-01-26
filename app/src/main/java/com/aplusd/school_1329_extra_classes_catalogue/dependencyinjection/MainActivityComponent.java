package com.aplusd.school_1329_extra_classes_catalogue.dependencyinjection;

import com.aplusd.school_1329_extra_classes_catalogue.extraclasseswork.ExtraClassAdapter;
import com.aplusd.school_1329_extra_classes_catalogue.viewmodels.ViewModelExtraClasses;

import dagger.Component;

/**
 * @author Azamat Dzhonov
 * @date 25.01.2018
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    ExtraClassAdapter getExtraClassAdapter();
    ViewModelExtraClasses getViewModelExtraClass();

}

package com.aplusd.school_1329_extra_classes_catalogue.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

/**
 * @author Azamat Dzhonov
 * @date 15.01.2018
 */

public class ViewModelExtraClasses extends ViewModel {


    @Inject
    public LiveDataCourses liveDataCourses = null;


    @Inject
    public ViewModelExtraClasses()
    {
        Log.i(Config.TAG_VIEW_MODEL, "ViewModelCreated");
    }


    public LiveDataCourses getExtraClasses(Context context)
    {
        if(liveDataCourses == null)
        {
            liveDataCourses = new LiveDataCourses(context);
        }
        return liveDataCourses;
    }
}

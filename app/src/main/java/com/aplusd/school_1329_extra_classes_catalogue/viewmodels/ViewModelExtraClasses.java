package com.aplusd.school_1329_extra_classes_catalogue.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

/**
 * @author Azamat Dzhonov
 * @date 15.01.2018
 */

public class ViewModelExtraClasses extends ViewModel {


    private LiveDataCourses liveDataCourses = null;

    public LiveDataCourses getExtraClasses(Context context)
    {
        if(liveDataCourses == null)
            liveDataCourses = new LiveDataCourses(context);
        return liveDataCourses;
    }



}

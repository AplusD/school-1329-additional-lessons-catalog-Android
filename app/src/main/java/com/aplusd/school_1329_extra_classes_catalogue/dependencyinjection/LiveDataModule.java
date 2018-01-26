package com.aplusd.school_1329_extra_classes_catalogue.dependencyinjection;

import android.content.Context;

import com.aplusd.school_1329_extra_classes_catalogue.model.ExtraClass;
import com.aplusd.school_1329_extra_classes_catalogue.viewmodels.Config;

import java.io.File;
import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * @author Azamat Dzhonov
 * @date 26.01.2018
 */

@Module (includes = ContextModule.class)
public class LiveDataModule {
    @Provides
    public Cache cache(File file)
    {
        return new Cache(file, 10 * 1000 * 1000);
    }

    @Provides
    public File file(Context context)
    {
        return new File(context.getCacheDir(), Config.CACHE_DIR);
    }

    @Provides
    public OkHttpClient okHttpClient(Cache cache)
    {
        return new OkHttpClient().newBuilder().cache(cache).build();
    }

    @Provides
    public ArrayList<ExtraClass> extraClasses()
    {
        return new ArrayList<ExtraClass>();
    }
}

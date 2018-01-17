package com.aplusd.school_1329_extra_classes_catalogue.viewmodels;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.util.Log;

import com.aplusd.school_1329_extra_classes_catalogue.model.ExtraClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Azamat Dzhonov
 * @date 16.01.2018
 */

public class LiveDataCourses extends LiveData<ArrayList<ExtraClass>> {


    public LiveDataCourses(Context context)
    {
        File cacheFile = new File(context.getCacheDir(), "usersCache");
        if(!cacheFile.isDirectory())
            cacheFile.mkdirs();

        Cache cache = new Cache(cacheFile, 10 * 1000 * 1000); //10 MB

        OkHttpClient client = new OkHttpClient().newBuilder().cache(cache).build();
        Request request = new Request.Builder().url(Config.URL_GET_COURSES).build();


        final ArrayList<ExtraClass> extraClassesObjects = new ArrayList<>();

        //Make call
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {

                    String result = response.body().string();

                    Log.e(Config.TAG_REQ, result);

                    JSONObject jsonObject = new JSONObject(result);

                    if (jsonObject.has(Config.FIELD_FREE)) {
                        JSONArray jsonArrayFree = jsonObject.getJSONArray(Config.FIELD_FREE);
                        for (int i = 0; i < jsonArrayFree.length(); i++)
                            extraClassesObjects.add(new ExtraClass(jsonArrayFree.getString(i), true));
                    }
                    if (jsonObject.has(Config.FIELD_PAID)) {
                        JSONArray jsonArrayFree = jsonObject.getJSONArray(Config.FIELD_PAID);
                        for (int i = 0; i < jsonArrayFree.length(); i++)
                            extraClassesObjects.add(new ExtraClass(jsonArrayFree.getString(i), false));
                    }
                    postValue(extraClassesObjects);
                }
                catch (JSONException js)
                {
                    js.printStackTrace();
                }
            }
        });
    }

}

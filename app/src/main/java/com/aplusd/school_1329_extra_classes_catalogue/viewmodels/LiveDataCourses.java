package com.aplusd.school_1329_extra_classes_catalogue.viewmodels;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Azamat Dzhonov
 * @date 16.01.2018
 */

public class LiveDataCourses extends LiveData<ArrayList<ExtraClass>> {


    public LiveDataCourses(final Context context)
    {
        File cacheFile = new File(context.getCacheDir(), "usersCache");
        if(!cacheFile.isDirectory())
            cacheFile.mkdirs();

        Cache cache = new Cache(cacheFile, 10 * 1000 * 1000); //10 MB

        final OkHttpClient client = new OkHttpClient()
                .newBuilder().cache(cache)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        if (isNetworkAvailable(context)) {
                            request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
                        } else {
                            request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
                        }
                        return chain.proceed(request);
                    }
                })
                .build();
        Request request = new Request.Builder().url(Config.URL_GET_COURSES).build();


        //Make call
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(Config.TAG_REQ, "Request failed - " + e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(Config.TAG_REQ, "Success request");
                parseAndPostValue(response.body().string());
            }
        });
    }

    private void parseAndPostValue(String str)
    {
        final ArrayList<ExtraClass> extraClassesObjects = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(str);

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
        }
        catch (JSONException js)
        {
            Log.e(Config.TAG_REQ, js.toString());
            js.printStackTrace();
        }
        postValue(extraClassesObjects);
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}

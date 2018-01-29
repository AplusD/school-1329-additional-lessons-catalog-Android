package com.aplusd.school_1329_extra_classes_catalogue.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.aplusd.school_1329_extra_classes_catalogue.R;
import com.aplusd.school_1329_extra_classes_catalogue.extraclasseswork.MainActivity;

/**
 * @author Azamat Dzhonov
 * @date 29.01.2018
 */

public class WidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;

        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];

            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
            views.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}

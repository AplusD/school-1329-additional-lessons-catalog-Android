package com.aplusd.school_1329_extra_classes_catalogue.classeslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;

import com.aplusd.school_1329_extra_classes_catalogue.R;


//Dagger
//LiveData ViewModel Кеширование данных - и как применять к MVVM MVP
//Data binding - использовать в проекте
//Расписана общая тема на приложение;
//AlarmManager make чтобы раз в день был запрос на сервер для получение расписания;
//Что нибудь новое по JSON сделай для парсинга.
//AAC
//Search view

public class MainActivity extends AppCompatActivity {

    private SearchView searchView = null;
    private RecyclerView recyclerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.searchView);
        recyclerView = findViewById(R.id.recyclerView);

    }
}

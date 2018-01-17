package com.aplusd.school_1329_extra_classes_catalogue.extraclasseswork;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.aplusd.school_1329_extra_classes_catalogue.R;
import com.aplusd.school_1329_extra_classes_catalogue.model.ExtraClass;
import com.aplusd.school_1329_extra_classes_catalogue.viewmodels.ViewModelExtraClasses;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ExtraClassAdapter extraClassAdapter = null;
    private ViewModelExtraClasses  viewModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(R.string.app_name);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        viewModel = ViewModelProviders.of(this).get(ViewModelExtraClasses.class);

        viewModel.getExtraClasses(getApplicationContext()).observe(this, new Observer<ArrayList<ExtraClass>>() {
            @Override
            public void onChanged(@Nullable ArrayList<ExtraClass> extraClasses) {
                if(extraClassAdapter == null) {
                    extraClassAdapter = new ExtraClassAdapter(getBaseContext());
                    recyclerView.setAdapter(extraClassAdapter);
                }
                extraClassAdapter.setCourses(extraClasses);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.isEmpty())
                    extraClassAdapter.setCourses(viewModel.getExtraClasses(getApplicationContext()).getValue());
                else
                    extraClassAdapter.setCourses(extraClassAdapter.searchClass(newText));
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.showAllClasses:
                extraClassAdapter.setCourses(viewModel.getExtraClasses(getApplicationContext()).getValue());
                break;
        }

        return true;
    }
}

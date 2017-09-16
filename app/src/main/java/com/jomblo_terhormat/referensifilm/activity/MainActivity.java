package com.jomblo_terhormat.referensifilm.activity;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jomblo_terhormat.referensifilm.R;
import com.jomblo_terhormat.referensifilm.adapter.FilmRecycleViewAdapter;
import com.jomblo_terhormat.referensifilm.entity.Film;
import com.jomblo_terhormat.referensifilm.networking.FilmLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Film>> {

    private static final int LOADER_ID = 54;
    private FilmRecycleViewAdapter filmRecycleViewAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(LOADER_ID, null, this);
        
        filmRecycleViewAdapter = new FilmRecycleViewAdapter(this, new ArrayList<Film>());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvItems);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);

    }


    @Override
    public Loader<List<Film>> onCreateLoader(int i, Bundle bundle) {
        if (mFilms == null) {
            return new FilmLoader(this,Film.UPCOMING);
        } else
            return null;
    }

    @Override
    public void onLoadFinished(Loader<List<Film>> loader, List<Film> films) {
        if (mFilms == null) {
            mFilms = films;
        }

    }

    @Override
    public void onLoaderReset(Loader<List<Film>> loader) {
    }
}

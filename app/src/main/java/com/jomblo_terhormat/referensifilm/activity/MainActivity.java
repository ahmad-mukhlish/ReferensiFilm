package com.jomblo_terhormat.referensifilm.activity;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.jomblo_terhormat.referensifilm.R;
import com.jomblo_terhormat.referensifilm.adapter.FilmRecycleViewAdapter;
import com.jomblo_terhormat.referensifilm.entity.Film;
import com.jomblo_terhormat.referensifilm.networking.FilmLoader;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Film>> {

    private static final int LOADER_ID = 54;
    private FilmRecycleViewAdapter filmRecycleViewAdapter;
    private List<Film> mFilms = null;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rvItems);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(LOADER_ID, null, this);
    }


    @Override
    public Loader<List<Film>> onCreateLoader(int i, Bundle bundle) {
        return new FilmLoader(this, Film.UPCOMING);

    }

    @Override
    public void onLoadFinished(Loader<List<Film>> loader, List<Film> films) {
        if (mFilms == null || mFilms.isEmpty()) {
            mFilms = films;
            updateUI(mFilms);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<Film>> loader) {
    }

    public void updateUI(List<Film> filmList) {
        filmRecycleViewAdapter = new FilmRecycleViewAdapter(this, filmList);
        recyclerView.setAdapter(filmRecycleViewAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.tentang)
            startActivity(new Intent(MainActivity.this, AboutActivity.class));
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFilms = null;
    }

}

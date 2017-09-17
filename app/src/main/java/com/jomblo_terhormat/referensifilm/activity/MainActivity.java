package com.jomblo_terhormat.referensifilm.activity;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

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
    private ActionBar mActionBar;
    private LinearLayout mLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.rvItems);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        ConnectivityManager mConnectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = mConnectivityManager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        LinearLayout error = (LinearLayout) findViewById(R.id.error);
        error.setVisibility(View.GONE);

        mLoading = (LinearLayout) findViewById(R.id.loading);


        mActionBar = getSupportActionBar();
        mActionBar.hide();

        if (isConnected) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(LOADER_ID, null, this);
        } else {
            error.setVisibility(View.VISIBLE);
        }

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
        mActionBar.show();
        mLoading.setVisibility(View.GONE);
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

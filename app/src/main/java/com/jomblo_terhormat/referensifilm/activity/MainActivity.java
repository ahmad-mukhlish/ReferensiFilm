package com.jomblo_terhormat.referensifilm.activity;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.jomblo_terhormat.referensifilm.R;
import com.jomblo_terhormat.referensifilm.adapter.FilmTabAdapter;
import com.jomblo_terhormat.referensifilm.entity.Film;
import com.jomblo_terhormat.referensifilm.networking.FilmLoader;

import java.util.List;

/**
 * Created by GOODWARE1 on 8/30/2017.
 */


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<List<Film>>> {

    private static final int LOADER_ID = 54;
    public static List<List<Film>> mFilms = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(LOADER_ID, null, this);




    }


    @Override
    public Loader<List<List<Film>>> onCreateLoader(int i, Bundle bundle) {
        if (mFilms == null) {
            return new FilmLoader(this, setLinks());
        } else
            return null;
    }

    @Override
    public void onLoadFinished(Loader<List<List<Film>>> loader, List<List<Film>> films) {
        if (mFilms == null)
        {
            Log.v("apa", "tercyduk");
            mFilms = films;
        }

        updateUI(mFilms);
    }

    @Override
    public void onLoaderReset(Loader<List<List<Film>>> loader) {
    }

    private String[] setTitle() {
        String titles[] = new String[FilmTabAdapter.TOTAL_FRAGMENT];
        titles[0] = "POPULAR";
        titles[1] = "TOP RATED";
        titles[2] = "UPCOMING";
        return titles;
    }

    private void updateUI(List<List<Film>> list) {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        FilmTabAdapter filmTabAdapter = new FilmTabAdapter(getSupportFragmentManager(), setTitle(), list);
        viewPager.setAdapter(filmTabAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


    }

    private String[] setLinks() {
        String[] link = new String[3];
        link[0] = Film.POPULAR;
        link[1] = Film.TOP_RATED;
        link[2] = Film.UPCOMING;
        return link;
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
            startActivity(new Intent(MainActivity.this, AboutActiviy.class));
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFilms = null;
    }
}

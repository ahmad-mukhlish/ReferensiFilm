package com.jomblo_terhormat.referensifilm.activity;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jomblo_terhormat.referensifilm.R;
import com.jomblo_terhormat.referensifilm.adapter.FilmTabAdapter;
import com.jomblo_terhormat.referensifilm.entity.Film;
import com.jomblo_terhormat.referensifilm.networking.FilmLoader;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<List<Film>>> {

    private static final int LOADER_ID = 54;
    FilmTabAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(LOADER_ID, null, this);


    }


    @Override
    public Loader<List<List<Film>>> onCreateLoader(int i, Bundle bundle) {
        return new FilmLoader(this, setLinks());
    }

    @Override
    public void onLoadFinished(Loader<List<List<Film>>> loader, List<List<Film>> films) {
        updateUI(films);
    }

    @Override
    public void onLoaderReset(Loader<List<List<Film>>> loader) {
    }

    private String[] setTitle() {
        String titles[] = new String[FilmTabAdapter.TOTAL_FRAGMENT];
        titles[0] = "POPULAR";
        titles[1] = "TOP RATED";
        titles[2] = "COMING SOON";
//        titles[3] = "ABOUT";
        return titles;
    }

    private void updateUI(List<List<Film>> list) {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new FilmTabAdapter(getSupportFragmentManager(), setTitle(), list);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private String[] setLinks(){
        String[] link = new String[3] ;
        link[0] = Film.POPULAR ;
        link[1] = Film.TOP_RATED ;
        link[2] = Film.UPCOMING ;
        return link ;
    }
}

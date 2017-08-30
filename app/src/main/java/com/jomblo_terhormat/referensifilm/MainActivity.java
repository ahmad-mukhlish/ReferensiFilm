package com.jomblo_terhormat.referensifilm;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.jomblo_terhormat.referensifilm.entity.Film;
import com.jomblo_terhormat.referensifilm.networking.FilmLoader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Film>> {

    public static final String API_KEY = "459d687b181bb31b7f514ca0a00e01c8";
    public static final String LINK = "https://api.themoviedb.org/3/movie/popular?api_key=459d687b181bb31b7f514ca0a00e01c8";
    private static final int LOADER_ID = 54;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(LOADER_ID, null, this);
    }


    @Override
    public Loader<List<Film>> onCreateLoader(int i, Bundle bundle) {
        return new FilmLoader(this,LINK) ;
    }

    @Override
    public void onLoadFinished(Loader<List<Film>> loader, List<Film> films) {
    }

    @Override
    public void onLoaderReset(Loader<List<Film>> loader) {

    }
}

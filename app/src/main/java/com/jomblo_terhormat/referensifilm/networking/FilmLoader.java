package com.jomblo_terhormat.referensifilm.networking;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.jomblo_terhormat.referensifilm.entity.Film;

import java.util.List;

public class FilmLoader extends AsyncTaskLoader<List<Film>> {

    private static final String LOG_TAG = FilmLoader.class.getName();
    private String mURl;


    public FilmLoader(Context context, String URl) {
        super(context);
        this.mURl = URl;
    }

    /**
     * Subclasses must implement this to take care of loading their data,
     * as per {@link #startLoading()}.  This is not called by clients directly,
     * but as a result of a call to {@link #startLoading()}.
     */
    @Override
    protected void onStartLoading() {
        forceLoad();
        Log.v(LOG_TAG, "On Start Loading");
    }

    @Override
    public List<Film> loadInBackground() {
        if (mURl == null) {
            return null;
        }
        Log.v(LOG_TAG, "Loading Background");
        return QueryUtils.fetchData(mURl);

    }
}
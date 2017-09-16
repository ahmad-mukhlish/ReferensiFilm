package com.jomblo_terhormat.referensifilm.activity;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jomblo_terhormat.referensifilm.R;
import com.jomblo_terhormat.referensifilm.adapter.FilmListAdapter;
import com.jomblo_terhormat.referensifilm.entity.Film;
import com.jomblo_terhormat.referensifilm.networking.FilmLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Film>> {

    private static final int LOADER_ID = 54;
    private FilmListAdapter filmListAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(LOADER_ID, null, this);
        ListView listView = (ListView) findViewById(R.id.list);
        filmListAdapter = new FilmListAdapter(this,new ArrayList<Film>());

//        FilmRecycleViewAdapter filmRecycleViewAdapter =
//                new FilmRecycleViewAdapter(getContext(), films);
//        RecyclerView recyclerView = rootView.findViewById(R.id.rvItems);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);


        listView.setAdapter(filmListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Film clickedFilm = filmListAdapter.getItem(position) ;
                Intent intent = new Intent(MainActivity.this,DetailActivity.class) ;
                intent.putExtra("gambar",clickedFilm.getmBackdrop_path()) ;
                intent.putExtra("judul",clickedFilm.getmTitle()) ;
                intent.putExtra("deskripsi",clickedFilm.getmOverview()) ;
                intent.putExtra("tanggal",clickedFilm.getmRelease_date()) ;
                intent.putExtra("rating",clickedFilm.getmVote_average()) ;
                startActivity(intent);
            }
        });
    }


    @Override
    public Loader<List<Film>> onCreateLoader(int i, Bundle bundle) {
        return new FilmLoader(this,Film.TOP_RATED) ;
    }

    @Override
    public void onLoadFinished(Loader<List<Film>> loader, List<Film> films) {
        filmListAdapter.clear();
        filmListAdapter.addAll(films);
    }

    @Override
    public void onLoaderReset(Loader<List<Film>> loader) {
        filmListAdapter.clear();
    }
}

package com.jomblo_terhormat.referensifilm.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jomblo_terhormat.referensifilm.R;
import com.jomblo_terhormat.referensifilm.activity.DetailActivity;
import com.jomblo_terhormat.referensifilm.adapter.FilmListAdapter;
import com.jomblo_terhormat.referensifilm.entity.Film;

import java.util.List;

/**
 * Created by GOODWARE1 on 8/30/2017.
 */

public class FilmListFragment extends Fragment {


    private FilmListAdapter mFilmListAdapter;


    public FilmListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.film_list, container, false);
        List<Film> films = getArguments().getParcelableArrayList("key");

        ListView listView = rootView.findViewById(R.id.list);
        mFilmListAdapter = new FilmListAdapter(getContext(), films);
        listView.setAdapter(mFilmListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Film clickedFilm = mFilmListAdapter.getItem(position);
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("gambar", clickedFilm.getmBackdrop_path());
                intent.putExtra("judul", clickedFilm.getmTitle());
                intent.putExtra("deskripsi", clickedFilm.getmOverview());
                intent.putExtra("tanggal", clickedFilm.getmRelease_date());
                intent.putExtra("rating", clickedFilm.getmVote_average());
                startActivity(intent);
            }
        });
        return rootView;
    }

}

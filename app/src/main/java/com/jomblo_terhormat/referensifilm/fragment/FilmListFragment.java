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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilmListFragment extends Fragment {

    private FilmListAdapter filmListAdapter;


    public FilmListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.film_list, container, false);


        ListView listView = rootView.findViewById(R.id.list);
        filmListAdapter = new FilmListAdapter(getContext(), new ArrayList<Film>());
        listView.setAdapter(filmListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Film clickedFilm = filmListAdapter.getItem(position);
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

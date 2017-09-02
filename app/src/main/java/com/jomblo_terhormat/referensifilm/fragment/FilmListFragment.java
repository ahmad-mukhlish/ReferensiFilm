package com.jomblo_terhormat.referensifilm.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jomblo_terhormat.referensifilm.R;
import com.jomblo_terhormat.referensifilm.adapter.FilmRecycleViewAdapter;
import com.jomblo_terhormat.referensifilm.entity.Film;

import java.util.List;

/**
 * Created by GOODWARE1 on 8/30/2017.
 */

public class FilmListFragment extends Fragment {


    public FilmListFragment() {
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.film_list, container, false);
        List<Film> films = getArguments().getParcelableArrayList("key");

        FilmRecycleViewAdapter filmRecycleViewAdapter =
                new FilmRecycleViewAdapter(getContext(), films);
        RecyclerView recyclerView = rootView.findViewById(R.id.rvItems);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(filmRecycleViewAdapter);

        return rootView;
    }

}

package com.jomblo_terhormat.referensifilm.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jomblo_terhormat.referensifilm.R;
import com.jomblo_terhormat.referensifilm.entity.Film;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by GOODWARE1 on 8/30/2017.
 */

public class FilmListAdapter extends ArrayAdapter<Film> {


    public FilmListAdapter(@NonNull Context context, @NonNull List<Film> films) {
        super(context, 0, films);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View listItemView, @NonNull ViewGroup parent) {

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_qu,parent,false) ;
        }

        ImageView imageView = listItemView.findViewById(R.id.gambar) ;
        TextView textView = listItemView.findViewById(R.id.judul) ;
        RatingBar ratingBar = listItemView.findViewById(R.id.rating) ;

        Film currentFilm = getItem(position) ;

        Picasso.with(getContext()).load(Film.rootImagePath+currentFilm.getmPoster_path()).into(imageView);
//        textView.setText(""+);

        ratingBar.setRating(currentFilm.getmVote_average());

        return listItemView ;
    }


}

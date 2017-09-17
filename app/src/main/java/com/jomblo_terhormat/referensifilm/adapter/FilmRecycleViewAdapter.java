package com.jomblo_terhormat.referensifilm.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jomblo_terhormat.referensifilm.R;
import com.jomblo_terhormat.referensifilm.activity.DetailActivity;
import com.jomblo_terhormat.referensifilm.entity.Film;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GOODWARE1 on 9/2/2017.
 */

public class FilmRecycleViewAdapter extends RecyclerView.Adapter<FilmRecycleViewAdapter.FilmViewHolder> {

    private Context mContext;
    private List<Film> mFilms;

    public FilmRecycleViewAdapter(Context mContext, List<Film> mFilms) {
        this.mContext = mContext;
        this.mFilms = mFilms;
    }

    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.list_qu, parent, false);
        return new FilmViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FilmViewHolder holder, int position) {
        Film currentFilm = mFilms.get(position);

        Picasso.with(mContext).
                load(Film.ROOT_IMAGE_PATH_POSTER + currentFilm.getmPoster_path()).
                placeholder(R.drawable.film).
                into(holder.mGambar);

        holder.mJudul.setText(currentFilm.getmTitle());
        holder.mItemView.setOnClickListener(new FilmListner(position));

    }

    @Override
    public int getItemCount() {
        return mFilms.size();
    }

    class FilmViewHolder extends RecyclerView.ViewHolder {

        ImageView mGambar;
        TextView mJudul;
        View mItemView;

        FilmViewHolder(View itemView) {
            super(itemView);
            mGambar = itemView.findViewById(R.id.gambar);
            mJudul = itemView.findViewById(R.id.judul);
            mItemView = itemView;

        }


    }

    class FilmListner implements View.OnClickListener {

        private int position;

        FilmListner(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            Film clickedFilm = mFilms.get(position);
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra("gambar", clickedFilm.getmBackdrop_path());
            intent.putExtra("judul", clickedFilm.getmTitle());
            intent.putExtra("deskripsi", clickedFilm.getmOverview());
            intent.putExtra("tanggal", clickedFilm.getmRelease_date());
            intent.putExtra("rating", clickedFilm.getmVote_average());
            intent.putExtra("cadangan", clickedFilm.getmPoster_path());
            view.getContext().startActivity(intent);
        }
    }

    private void setFilter(List<Film> selectedFilms) {

        mFilms = new ArrayList<Film>();
        mFilms.addAll(selectedFilms);
        notifyDataSetChanged();
    }


}

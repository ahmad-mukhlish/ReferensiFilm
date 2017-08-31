package com.jomblo_terhormat.referensifilm.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GOODWARE1 on 8/30/2017.
 */

public class Film implements Parcelable {


    private String mTitle;
    private String mOverview;
    private String mPoster_path;
    private String mBackdrop_path;
    private float mVote_average;
    private String mRelease_date;

    public static final String ROOT_IMAGE_PATH_POSTER = "http://image.tmdb.org/t/p/w154/";
    public static final String ROOT_IMAGE_PATH_DETAIL = "http://image.tmdb.org/t/p/w780/";

    public static final String POPULAR = "https://api.themoviedb.org/3/movie/popular?api_key=459d687b181bb31b7f514ca0a00e01c8";
    public static final String TOP_RATED = "https://api.themoviedb.org/3/movie/top_rated?api_key=459d687b181bb31b7f514ca0a00e01c8";
    public static final String UPCOMING = "https://api.themoviedb.org/3/movie/upcoming?api_key=459d687b181bb31b7f514ca0a00e01c8";

    public Film(String title, String overview, String poster_path, String backdrop_path, float vote_average, String release_date) {

        this.mTitle = title;
        this.mOverview = overview;
        this.mPoster_path = poster_path;
        this.mBackdrop_path = backdrop_path;
        this.mVote_average = vote_average;
        this.mRelease_date = release_date;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmOverview() {
        return mOverview;
    }

    public String getmPoster_path() {
        return mPoster_path;
    }

    public String getmBackdrop_path() {
        return mBackdrop_path;
    }

    public float getmVote_average() {
        return mVote_average;
    }

    public String getmRelease_date() {
        return mRelease_date;
    }

    @Override
    public String toString() {
        return "Film{" +
                "mTitle='" + mTitle + '\'' +
                ", mOverview='" + mOverview + '\'' +
                ", mPoster_path='" + mPoster_path + '\'' +
                ", mBackdrop_path='" + mBackdrop_path + '\'' +
                ", mVote_average=" + mVote_average +
                ", mRelease_date='" + mRelease_date + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}

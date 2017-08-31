package com.jomblo_terhormat.referensifilm.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jomblo_terhormat.referensifilm.entity.Film;
import com.jomblo_terhormat.referensifilm.fragment.AboutFragment;
import com.jomblo_terhormat.referensifilm.fragment.FilmListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GOODWARE1 on 8/30/2017.
 */

public class FilmTabAdapter extends FragmentStatePagerAdapter {

    public static final int TOTAL_FRAGMENT = 4;
    private String mTitles[] ;
    private List<List<Film>> mLists;

    public FilmTabAdapter(FragmentManager fm, String[] titles, List<List<Film>> lists) {
        super(fm);
        this.mTitles = titles;
        this.mLists = lists;
    }


    @Override
    public Fragment getItem(int position) {

        Fragment fragment;
        if (position != 3) {
            fragment = new FilmListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("key", (ArrayList<Film>) mLists.get(position));
            fragment.setArguments(bundle);
        } else {
            fragment = new AboutFragment() ;
        }
        return fragment;
    }


    @Override
    public int getCount() {
        return TOTAL_FRAGMENT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

}

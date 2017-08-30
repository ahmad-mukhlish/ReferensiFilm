package com.jomblo_terhormat.referensifilm.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jomblo_terhormat.referensifilm.entity.Film;
import com.jomblo_terhormat.referensifilm.fragment.FilmListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GOODWARE1 on 8/23/2017.
 */

public class FilmTabAdapter extends FragmentStatePagerAdapter {

    public static final int TOTAL_FRAGMENT = 4;
    String titles[] = new String[TOTAL_FRAGMENT];
    private List<Film> list;

    public FilmTabAdapter(FragmentManager fm, String[] titles, List<Film> list) {
        super(fm);
        this.titles = titles;
        this.list = list;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new FilmListFragment();

//        if (position == 0)
//            fragment = new FirstFragment();
//        else if (position == 1)
//            fragment = new SecondFragment();
//        else
//            return null;

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("key", (ArrayList<Film>) list);
        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}

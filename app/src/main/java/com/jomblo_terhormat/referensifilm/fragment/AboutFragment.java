package com.jomblo_terhormat.referensifilm.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jomblo_terhormat.referensifilm.R;

/**
 * Created by GOODWARE1 on 8/30/2017.
 */

public class AboutFragment extends Fragment {


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        ImageButton fb = rootView.findViewById(R.id.klikfb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ngelink("https://web.facebook.com/ahmadmukhlis.saputra");
            }
        });

        ImageButton github = rootView.findViewById(R.id.klikgithub);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ngelink("https://github.com/ahmad-mukhlish");
            }
        });

        ImageButton gplus = rootView.findViewById(R.id.klikgplus);
        gplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ngelink("https://plus.google.com/u/0/116489913115605252616");
            }
        });

        TextView linknya =  rootView.findViewById(R.id.linknya);
        linknya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ngelink(getString(R.string.link));
            }
        });

        return rootView;
    }


    private void ngelink(String url) {
        Uri uriUrl = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW, uriUrl));
    }


}
